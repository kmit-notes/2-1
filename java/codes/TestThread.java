public class TestThread {
    public static void main(String[] args) {
        Counter c=new Counter();

        multiply m=new multiply();

        divide d=new divide();

        Thread t=new Thread(c,"KMIT");
        t.start();

        Thread t1=new Thread(m,"KMEC");
        t1.start();

        Thread t2=new Thread(d,"NGIT");
        t2.start();

        System.out.println("Exiting MAIN.");

    }
}
