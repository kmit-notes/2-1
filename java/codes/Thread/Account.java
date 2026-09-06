public class Account {
    Customer c;
    Account(Customer c){
        this.c=c;
    }
    public void withdraw(double amount){
        double x=c.getBalance();
        if (x-amount>1000){
            x-=amount;
            c.setBalance(x);
            System.out.println("₹ "+amount+" has been withdrawn from Account no: "+c.getAccno());
        }
        else{
            System.out.println("Insufficient Funds.");
        }
    }
    public void deposit(double amount){
        double x=c.getBalance();
        x+=amount;
        c.setBalance(x);
        System.out.println("₹ "+amount+" has been deposited into Account no': "+c.getAccno());
    }
}



// 