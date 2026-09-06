package q2;

import java.util.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class Admin implements Runnable {
    private final PrintManager manager;

    public Admin(PrintManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Admin: " + manager.getStatus());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
        }
    }
}


class Consumer implements Runnable {
    private final String name;        
    private final PrintManager manager;

    public Consumer(String name, PrintManager manager) {
        this.name = name;
        this.manager = manager;
    }

    @Override
    public void run() {
        try {
            while (true) {
                PrintJob job = manager.takeJob();
                if (job == null) {
                    
                    break;
                }

                System.out.println(String.format("%s printed %s",
                        name, job));

                manager.totalPrinted.incrementAndGet();
                if (job.getPriority() == PrintJob.Priority.VIP) {
                    manager.vipPrinted.incrementAndGet();
                } else {
                    manager.normalPrinted.incrementAndGet();
                }

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class JobIdGenerator {
    private static final AtomicInteger counter = new AtomicInteger(1);

    public static int getNext() { return counter.getAndIncrement(); }
}


class Main {
    public static void main(String[] args) throws InterruptedException {
        final int K = 5;          
        final int N = 10;         
        final int PRODUCERS = 3;  

        PrintManager manager = new PrintManager(K, PRODUCERS);

        List<Thread> producerThreads = new ArrayList<>();
        producerThreads.add(new Thread(new Producer("P1",
                PrintJob.Priority.NORMAL, N, manager)));
        producerThreads.add(new Thread(new Producer("P2",
                PrintJob.Priority.NORMAL, N, manager)));
        producerThreads.add(new Thread(new Producer("P3",
                PrintJob.Priority.VIP,    N, manager)));

        List<Thread> consumerThreads = new ArrayList<>();
        consumerThreads.add(new Thread(new Consumer("Printer-A", manager)));
        consumerThreads.add(new Thread(new Consumer("Printer-B", manager)));

        Thread admin = new Thread(new Admin(manager));
        admin.setDaemon(true); 

        List<Thread> all = new ArrayList<>();
        all.addAll(producerThreads);
        all.addAll(consumerThreads);
        all.add(admin);

        all.forEach(Thread::start);

        for (Thread t : producerThreads) t.join();

        for (Thread t : consumerThreads) t.join();

        admin.interrupt();
        admin.join();

        System.out.println("Total jobs submitted: " + manager.totalSubmitted);
        System.out.println("Total jobs printed : " + manager.totalPrinted);
        System.out.println("VIP jobs printed   : " + manager.vipPrinted);
        System.out.println("NORMAL jobs printed: " + manager.normalPrinted);
    }
}

class PrintJob {
    public enum Priority { VIP, NORMAL }

    private final int jobId;
    private final String owner;
    private final int pages;
    private final Priority priority;

    public PrintJob(int jobId, String owner, int pages, Priority priority) {
        this.jobId = jobId;
        this.owner = owner;
        this.pages = pages;
        this.priority = priority;
    }

    public int getJobId()  { return jobId; }
    public String getOwner() { return owner; }
    public int getPages() { return pages; }
    public Priority getPriority() { return priority; }

    @Override
    public String toString() {
        return String.format("jobId=%d owner=%s pages=%d priority=%s",
                jobId, owner, pages, priority);
    }
}

class PrintManager {
    public final PrintSpooler spooler;
    private final int producersTotal;

    // flags & counters
    private final AtomicInteger producersFinished = new AtomicInteger(0);
    private final AtomicBoolean producersDone = new AtomicBoolean(false);

    public final AtomicInteger totalSubmitted = new AtomicInteger(0);
    public final AtomicInteger totalPrinted  = new AtomicInteger(0);
    public final AtomicInteger vipPrinted    = new AtomicInteger(0);
    public final AtomicInteger normalPrinted = new AtomicInteger(0);

    public PrintManager(int capacity, int producersTotal) {
        this.spooler = new PrintSpooler(capacity);
        this.producersTotal = producersTotal;
    }

    public void producerFinished() {
        int left = producersFinished.incrementAndGet();
        if (left == producersTotal) {
            producersDone.set(true);
            synchronized (spooler) {          
                spooler.notifyAll();
            }
        }
    }

    public boolean isProducersDone() {
        return producersDone.get();
    }

    // for producers
    public void submitJob(PrintJob job) throws InterruptedException {
        spooler.submitJob(job);
        totalSubmitted.incrementAndGet();
    }

    // for consumers
    public PrintJob takeJob() throws InterruptedException {
        synchronized (spooler) {
            while (spooler.isEmpty()) {
                if (isProducersDone()) {
                    return null; 
                }
                spooler.wait();                
            }
            PrintJob job = spooler.pollJob();  
            spooler.notifyAll();              
            return job;
        }
    }

    // for admin
    public String getStatus() {
        return spooler.status();
    }
}


class PrintSpooler {
    private final int capacity;
    private final Queue<PrintJob> vipQueue   = new LinkedList<>();
    private final Queue<PrintJob> normalQueue = new LinkedList<>();

    public PrintSpooler(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void submitJob(PrintJob job) throws InterruptedException {
        while (size() == capacity) {
            wait();                               }
        if (job.getPriority() == PrintJob.Priority.VIP) {
            vipQueue.offer(job);
        } else {
            normalQueue.offer(job);
        }
        notifyAll();                     
    }

    public synchronized PrintJob pollJob() {
        if (!vipQueue.isEmpty()) {
            return vipQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            return normalQueue.poll();
        } else {
            return null;                 
        }
    }

    public synchronized int size() {
        return vipQueue.size() + normalQueue.size();
    }

    public synchronized int vipCount()  { return vipQueue.size(); }
    public synchronized int normalCount() { return normalQueue.size(); }

    public synchronized boolean isEmpty() { return size() == 0; }

    public synchronized String status() {
        return String.format("Spooler size=%d, VIP=%d, NORMAL=%d",
                size(), vipCount(), normalCount());
    }
}

class Producer implements Runnable {
    private final String name;             
    private final PrintJob.Priority priority; 
    private final int jobsToSubmit;        
    private final PrintManager manager;
    private final Random rnd = new Random();

    public Producer(String name, PrintJob.Priority priority, int jobsToSubmit,
                    PrintManager manager) {
        this.name = name;
        this.priority = priority;
        this.jobsToSubmit = jobsToSubmit;
        this.manager = manager;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < jobsToSubmit; i++) {
                int jobId = JobIdGenerator.getNext();
                String owner = name + "-Owner-" + (i + 1);
                int pages = 1 + rnd.nextInt(20); 
                PrintJob job = new PrintJob(jobId, owner, pages, priority);

                manager.submitJob(job);
                System.out.println(String.format("Producer-%s submitted %s",
                        name, job));
                Thread.sleep(rnd.nextInt(50));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            manager.producerFinished();
        }
    }
}