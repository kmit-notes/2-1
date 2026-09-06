// Exercise 4:
// Create two threads A and B. In thread A, print “Thread A started”, sleep for 2 seconds, 
// then print “Thread A finished”. In main(), call join() on thread A before starting thread B. 
// Verify that B starts only after A is complete.
public class Ex4 implements Runnable{
    public void run(){
        System.out.println("Thread "+Thread.currentThread().getName()+" started...");
        Thread.sleep(2000);
        System.out.println("Thread "+Thread.currentThread().getName()+" finished.");
    }
}
