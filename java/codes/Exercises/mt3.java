// Exercise 3:
// Create a thread class that extends Thread. Override run() to print the current thread name 5 times. 
// In main(), create three threads, assign different priorities, and start them. Observe whether the 
// highest priority thread always finishes first.
public class mt3 {
    public static void main(String[] args) {
        Ex3 e=new Ex3();
        Thread t1=new Thread(e,"T1");
        Thread t2=new Thread(e,"T2");
        Thread t3=new Thread(e,"T3");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
