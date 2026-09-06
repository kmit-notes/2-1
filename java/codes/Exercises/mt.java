public class mt {
    public static void main(String[] args) {
        Ex1 e=new Ex1();
        Thread t1=new Thread(e);
        Thread t2=new Thread(e);
        t1.start();
        t2.start();
    }
}
