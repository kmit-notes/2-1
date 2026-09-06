// Exercise 1:
// Create a class that implements Runnable. Inside run(), print numbers from 1 to 5 with a 
// 500 ms delay between each print. Create two threads using this Runnable and start both. Observe the output order.
public class Ex1 implements Runnable{
    public void run(){
        for (int i=1;i<=5;i++){
            System.out.println(i);
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

