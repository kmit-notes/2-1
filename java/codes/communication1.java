public class communication1 {
    Student1 s;
    communication1(Student1 s){
        this.s=s;
    }
    void sendSMS(){
        System.out.println("Sending SMS to "+s.getPhno());
        for (int i=0;i<100;i++){

        }
        System.out.println("Sent SMS to "+s.getPhno());
    }
    void sendEmail(){
        System.out.println("Sending mail to "+s.getEmail());
        for (int i=0;i<100;i++){

        }
        System.out.println("Sent mail to "+s.getEmail());
    }
    void sendWhatsApp(){
        System.out.println("Sending message to "+s.getPhno());
        for (int i=0;i<100;i++){

        }
        System.out.println("Sent message to "+s.getPhno());
    }
}

// public class communication1 {
//     void sendSMS(Student1 s){
//         System.out.println("Sending SMS to "+s.getPhno());
//         for (int i=0;i<100;i++){

//         }
//         System.out.println("Sent SMS to "+s.getPhno());
//     }
//     void sendEmail(Student1 s){
//         System.out.println("Sending mail to "+s.getEmail());
//         for (int i=0;i<100;i++){

//         }
//         System.out.println("Sent mail to "+s.getEmail());
//     }
//     void sendWhatsApp(Student1 s){
//         System.out.println("Sending message to "+s.getPhno());
//         for (int i=0;i<100;i++){

//         }
//         System.out.println("Sent message to "+s.getPhno());
//     }
// }
