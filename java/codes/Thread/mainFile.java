// import Thread.*;
import java.util.ArrayList;
import java.util.List;

public class mainFile {
    public static void main(String[] args) {
        List <Customer> c=new ArrayList<>();
        c.add(new Customer("Reena", 50000, "AC01"));
        c.add(new Customer("Meena", 55000, "AC02"));
        c.add(new Customer("Seena", 60000, "AC03"));
        c.add(new Customer("Teena", 65000, "AC04"));
        c.add(new Customer("Ramesh", 70000, "AC05"));
        c.add(new Customer("Suresh", 75000, "AC06"));
        c.add(new Customer("Karishma", 80000, "AC07"));
        c.add(new Customer("Kailash", 85000, "AC08"));
        c.add(new Customer("Kabir", 90000, "AC09"));
        c.add(new Customer("Sushma", 100000, "AC10"));

        // Account a=new Account(null)
        for (Customer x: c){
            Account a=new Account(x);
            Deposit d=new Deposit(a,5000);
            Withdraw w=new Withdraw(a, 6000);
            Thread t1=new Thread(d);
            t1.start();
            Thread t2=new Thread(w);
            t2.start();

        }
    }
}
