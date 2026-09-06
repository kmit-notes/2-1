public class Student {
    public static void main(String[] args){
        

        Communication c=new Communication();
        SMS s=new SMS(c);
        Email e=new Email(c);
        WhatsApp w=new WhatsApp(c);
        
        Thread t1=new Thread(s);
        t1.start();

        Thread t2=new Thread(e);
        t2.start();

        Thread t3=new Thread(w);
        t3.start();
    }
}
