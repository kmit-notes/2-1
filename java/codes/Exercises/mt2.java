public class mt2 {
    public static void main(String[] args) {
        Ex2a e1=new Ex2a();
        Ex2b e2=new Ex2b();

        Thread t1=new Thread(e1);
        Thread t2=new Thread(e2);

        t1.start();
        t2.start();
    }
    
}
