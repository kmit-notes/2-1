/**Create a class that implements Runnable. Inside run(), print numbers from 1 to 5 with a 500 ms delay between each print. Create two threads using this Runnable and start both. Observe the output order. */
public class t1 {

    static class NumberPrinter implements Runnable {
        private final String id;

        NumberPrinter(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + id + ": " + i);
                try {
                    Thread.sleep(500); // 500ms delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread " + id + " interrupted");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread tA = new Thread(new NumberPrinter("A"));
        Thread tB = new Thread(new NumberPrinter("B"));

        tA.start();
        tB.start();

        try {
            tA.join();
            tB.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}