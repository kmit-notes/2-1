/**Exercise 4:
Create two threads A and B. In thread A, print “Thread A started”, sleep for 2 seconds, then print “Thread A finished”. In main(), call join() on thread A before starting thread B. Verify that B starts only after A is complete. */


class ThreadA extends Thread {
    @Override
    public void run() {
        System.out.println("Thread A started");
        try {
            Thread.sleep(2000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread A finished");
    }
}
class ThreadB extends Thread {
    @Override
    public void run() {
        System.out.println("Thread B started");
        System.out.println("Thread B finished");
    }
}

public class threads4 {
    public static void main(String[] args) throws InterruptedException {

        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();

        a.start();  
        a.join();    
        b.start();   
    }
}