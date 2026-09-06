/**
 * Create 2 threads which count from 1-100
 * Create 4 threads which count from 100-1
 * Start all 6 threads 
 * Print name of the thread - count
 */
public class p0{
    public static void main(String[] args) throws InterruptedException{

        Counter c = new Counter();
        RCounter rc=new RCounter();

        Thread t1 = new Thread(c,"a");
        Thread t2 = new Thread(c,"b");
        Thread t3 = new Thread(rc,"c");
        Thread t4 = new Thread(rc,"d");
        Thread t5 = new Thread(rc,"e");
        Thread t6 = new Thread(rc,"f");
        
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        t5.start();
        t5.join();
        t6.start();
        t6.join();

        System.out.println("EXITING the main");
    }

}
class Counter implements Runnable{
    @Override
    public void run(){
        for (int i = 0;i<100;++i){
            System.out.println(Thread.currentThread().getName()+i);
            
    }
}
}
class RCounter implements Runnable{
    @Override
    public void run(){
        for (int i = 100;i>0;--i){
            System.out.println(Thread.currentThread().getName()+i);
            
    }
}
}