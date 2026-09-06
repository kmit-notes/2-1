import java.util.ArrayList;
import java.util.List;

public class MT {
    public static void main(String[] args) {
        List <Student1> s=new ArrayList<>();
        s.add(new Student1("Reena", 101, "reena@gmail.com", "1782895478"));
        s.add(new Student1("Teena", 102, "teena@gmail.com", "9059847578"));
        s.add(new Student1("Meena", 103, "meena@gmail.com", "9392224626"));
        s.add(new Student1("Seena", 104, "seena@gmail.com", "7854515655"));
        
        

        for (Student1 x: s){
            communication1 c=new communication1(x);
            SMS s1=new SMS(c);
            Email e=new Email(c);
            WhatsApp w=new WhatsApp(c);
            Thread t1=new Thread(s1);
            t1.start();

            Thread t2=new Thread(e);
            t2.start();

            Thread t3=new Thread(w);
            t3.start();
        }

    }
}


// import java.util.ArrayList;
// import java.util.List;

// public class MT {
//     public static void main(String[] args) {
//         List <Student1> s=new ArrayList<>();
//         s.add(new Student1("Reena", 101, "reena@gmail.com", "1782895478"));
//         s.add(new Student1("Teena", 102, "teena@gmail.com", "9059847578"));
//         s.add(new Student1("Meena", 103, "meena@gmail.com", "9392224626"));
//         s.add(new Student1("Seena", 104, "seena@gmail.com", "7854515655"));
//         communication1 c=new communication1();
        
        

//         for (Student1 x: s){
//             SMS s1=new SMS(c,x);
//             Email e=new Email(c,x);
//             WhatsApp w=new WhatsApp(c,x);
//             Thread t1=new Thread(s1);
//             t1.start();

//             Thread t2=new Thread(e);
//             t2.start();

//             Thread t3=new Thread(w);
//             t3.start();
//         }

//     }
// }
