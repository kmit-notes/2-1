public class threading{
    public static void main(String[] args) throws InterruptedException{
        Counter c = new Counter();

        Thread t = new Thread(c,"KMIT");
        
        Thread t1 = new Thread(c,"NGIT");
        
        Thread t2 = new Thread(c,"KMEC");

        Thread t3= new Thread(c,"CGIT");
        
        t.start();
        t.join();
        t1.start();
        t1.join();   

        t2.start();
        t2.join(); 

        t3.start();
        t3.join();

        System.out.println("EXITING the main");
    }

}
 class Counter implements Runnable{
    @Override
    public void run(){
        for (int i = 0;i<100;++i){
            System.out.println(Thread.currentThread().getName()+i);
            try {
                Thread.sleep(10); // PRINT EVERY 1ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}