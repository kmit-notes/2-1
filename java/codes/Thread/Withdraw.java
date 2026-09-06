public class Withdraw implements Runnable {
    Account a;
    double amount;
    Withdraw(Account a,double amount){
        this.a=a;
        this.amount=amount;
    }
    public void run(){
        a.withdraw(amount);
    }
}
