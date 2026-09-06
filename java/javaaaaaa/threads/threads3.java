/**Exercise 3:
Create a thread class that extends Thread. Override run() to print the current thread name 5 times. In main(), create three threads, assign different priorities, and start them. Observe whether the highest priority thread always finishes first.
 */

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);   
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - " + i);
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class threads3 {
    public static void main(String[] args) {

        MyThread t1 = new MyThread("Thread-A");
        MyThread t2 = new MyThread("Thread-B");
        MyThread t3 = new MyThread("Thread-C");

        t1.setPriority(Thread.MIN_PRIORITY);  
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);  

        t1.start();
        t2.start();
        t3.start();
    }
}