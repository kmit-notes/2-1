// Exercise 3:
// Create a thread class that extends Thread. Override run() to print the current thread name 5 times. 
// In main(), create three threads, assign different priorities, and start them. Observe whether the 
// highest priority thread always finishes first.
public class Ex3 extends Thread{
    public void run(){
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
