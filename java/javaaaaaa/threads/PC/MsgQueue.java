package PC;

public class MsgQueue {
    private String msg ; 
    boolean empty = true;
public synchronized String getMsg() {
    if(empty != false)
    {
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    for (int i = 0; i < 1000; i++) {
        
    }
    System.out.println("[Consumer] recvd"+msg);
    empty = true;
    notify();
    return msg;
}
public synchronized void setMsg(String msg) {

    if(empty == true)
    { 
        for (int i = 0; i < 1000; i++) {}
       this.msg = msg;
       System.out.println("[Producer] sent"+msg);
       empty = false;
      notify();
    }
 try {
    wait();
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}    


 
}
}
