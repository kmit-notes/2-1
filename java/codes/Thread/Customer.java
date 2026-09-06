public class Customer {
    private String name;
    private double balance;
    private String Accno;
    Customer(String name,double balance,String Accno){
        this.name=name;
        this.balance=balance;
        this.Accno=Accno;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double amount){
        balance=amount;
    }
    public String getAccno(){
        return Accno;
    }
}
