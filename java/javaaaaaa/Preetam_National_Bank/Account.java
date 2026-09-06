public abstract class Account{
    String name;
    private double balance;
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    abstract public void deposit(double amount);
    public boolean withdraw(double amount){
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double nb){
        balance = nb;
    }

}