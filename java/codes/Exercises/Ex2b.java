// Exercise 2:
// Create two threads: one prints even numbers from 2 to 10, the other prints odd numbers from 1 to 9. 
// Use Thread.sleep(300) inside each run() to slow output. Start both threads and compare results on 
// multiple executions.

public class Ex2b implements Runnable{
    public void run(){
        for (int i=1;i<=9;i+=2){
            System.out.println(i);
            try {
                Thread.sleep(300);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
