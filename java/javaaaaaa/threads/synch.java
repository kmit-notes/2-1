class task implements Runnable {

    void m1(String name) {
        for(int i=0;i<10;i++){
        System.out.println(i + name + ": m1 called");}
    }

    synchronized void m2(String name) {
       for(int i=0;i<10;i++){
        System.out.println(i + name + ": m2 called");}
    }

    void m3(String name) {
        for(int i=0;i<10;i++){
        System.out.println(i + name + ": m3 called");}
    }

    public void run() {
        String name = Thread.currentThread().getName();
        m1(name);
        m2(name);
        m3(name);
    }
}

class synch extends Thread {

    synch(Runnable r) {   
        super(r);
    }

    public static void main(String[] args) {

        task t = new task();       

        Thread t1 = new Thread(t, "t1");  
        Thread t2 = new Thread(t,"t2");    

        t1.start();
        t2.start();
    }
}