public class WhatsApp implements Runnable{
    communication1 c;
    WhatsApp(communication1 c){
        this.c=c;
    }
    public void run(){
        c.sendWhatsApp();
    }
}


// public class WhatsApp implements Runnable{
//     communication1 c;
//     Student1 s;
//     WhatsApp(communication1 c,Student1 s){
//         this.c=c;
//     }
//     public void run(){
//         c.sendWhatsApp(s);
//     }
// }
