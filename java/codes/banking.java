/*Create a class BankAccount with:
Fields: accountNumber, accountHolder, balance.
A static variable bankName (same for all accounts).
Constructor that initializes account details.
Methods: deposit(amount), withdraw(amount), displayAccount().
A static method to change the bank name.
👉 Extra Challenge:
Keep track of total number of accounts with a static counter.
Prevent overdrawing (balance can’t go below 0).
Write a test program that creates 3 accounts and modifies bankName in between—check how it affects all objects.*/
class BankAccount{
    String accountHolder;
    String accountNumber;
    double balance;
    static String bankName="SBI";
    static int counter=0;
    {
        counter++;
        System.out.println("The total no.of accounts is: "+counter);
    }
    BankAccount(String accountNumber,String accountHolder,double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    BankAccount(String accountNumber,String accountHolder){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
    }
    BankAccount(){
        balance=1000;
        accountHolder="Unknown";
        accountNumber="XXXXXXX";
    }
    void deposit(double amount){
        balance+=amount;
    }
    void withdraw(double amount){
        if (balance-amount<1000){
            System.out.println("Insufficient funds.");
            return;
        }
        balance-=amount;
    }
    double balance(){
        return balance;
    }
    void displayAccount(){
        System.out.println("Bank Name: "+bankName);
        System.out.println("Account holder Name: "+accountHolder);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
        System.out.println("");
    }
}
public class banking {
    public static void main(String[] args) {
        BankAccount b1=new BankAccount("1AGDHSJQ973","Manasa",15000);
        b1.deposit(1000);
        b1.withdraw(10000);
        b1.displayAccount();
        BankAccount b3=new BankAccount();
        BankAccount b4=new BankAccount();
        BankAccount b2=new BankAccount();
        BankAccount b5=new BankAccount();


    }
}
