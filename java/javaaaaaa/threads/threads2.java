// threads2.java

class EvenThread implements Runnable {

    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(300); // 300 ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(300); // 300 ms delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class threads2 {
    public static void main(String[] args) {

        Thread even = new Thread(new EvenThread(), "EvenThread");
        Thread odd  = new Thread(new OddThread(),  "OddThread");

        even.start();
        odd.start();
    }
}