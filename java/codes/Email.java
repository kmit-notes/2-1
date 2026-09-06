public class Email implements Runnable{
    communication1 c;
    Email(communication1 c){
        this.c=c;
    }
    public void run(){
        c.sendEmail();
    }
}