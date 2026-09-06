/** 
Create a class that implements Runnable. 
Inside run(), print numbers from 1 to 5 with a 500 ms delay between each print. 
Create two threads using this Runnable and start both. Observe the output order. 
*/

class threads implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(500);   // 500 ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class threads1 {
    public static void main(String[] args) {

        threads np = new threads();

        Thread t1 = new Thread(np, "Thread-1");
        Thread t2 = new Thread(np, "Thread-2");

        t1.start();
        t2.start();
    }
}