public class Deposit implements Runnable{
    Account a;
    double amount;
    Deposit(Account a,double amount){
        this.a=a;
        this.amount=amount;
    }
    public void run(){
        a.deposit(amount);
    }
}
