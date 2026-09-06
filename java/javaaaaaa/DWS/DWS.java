abstract class DWS {
    protected String name;
    protected double balance;
    protected String[] transactionHistory = new String[500];
    protected int transactionCount = 0;

    public DWS(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void addMoney(double amount);
    public abstract void pay(double amount, DWS receiver);
    public abstract void earnRewards();

    public void showTransactionHistory() {
        System.out.println("Transaction history for " + name + ":");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactionHistory[i]);
        }
    }
}