public class SMS implements Runnable{
    communication1 c;
    SMS(communication1 c){
        this.c=c;
    }
    public void run(){
        c.sendSMS();
    }
}
