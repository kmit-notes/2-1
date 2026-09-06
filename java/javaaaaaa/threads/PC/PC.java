package PC;


class Consumer implements Runnable {
    MsgQueue msg;
    Consumer(MsgQueue s)
    {
        this.msg = s;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            msg.getMsg();
        }
        
}
}
class Producer implements Runnable 
{
    MsgQueue msg;
    Producer(MsgQueue s)
    {
        this.msg = s;
    }
    @Override
    public void run() {
    for (int i = 0; i < 10; i++) {
         msg.setMsg(i+"");
    }
     
    }
}

public class PC {
    public static void main(String[] args) {
        MsgQueue m = new MsgQueue();
        Producer p = new Producer(m);
        Consumer c = new Consumer(m);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}

public class g implements Runnable{
    @Override
    public void run() {
       
        m2();
       
    }

  
     private static synchronized void m2() {
       for (int i =200; i < 300; i++) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+i+ " m2 called");
       }
    }
   
}

public class gtest {
    public static void main(String[] args) {
        g d = new g();
        Thread t1 = new Thread(d,"t1");
        Thread t2 = new Thread(d, "t2");
        t1.start();
        t2.start();
    }
}

public class Producer {
    
}


