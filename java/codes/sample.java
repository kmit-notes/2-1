/*
Preetam National Bank allows current and savings account. all types of account can withdraw and deposit 
1. Current account has a overdraft facility which allow you to withdraw more  money than your Balance.
2. It has an interest rate of only 5%
3. Current account does not let you have FIxed Deposit
4. There is no transaction limit
Whereas saving account needs to maintain MIN_BAL Balance, Fixed Deposit is allowed for minimum of 2 years , 
interest rate is 8.25% per annum. You can"t remove money during the lock-in period.
Transactions limit is only 50000 more than that the bank does not allow to withdraw in a given day.
Overdraft limit is only MIN_BAL0 for current account.
a)Ram opens 2 accounts in the bank, one savings with MIN_BAL0 and current with 500 only.
Shyam opens 2 account in the same bank, current account with 20000 and 40000 in savings account.
b)Ram is businessman whose needs to do a lot of transactions in a single day. Ram deposits 20000 in savings account and 60000 in current account
c)He makes an FD for 25000 for 3 years
d)Ram needs to pay 6000 to paper vendor.
4000 to canteen guy, 25000 to transport.
Ram transfers 20000 to Shyam . Can he transfer? no
is Ram allowed to make an FD? yes
What would be his amount when it matures.
e)Shyam needs to send 30000 to his sister. How can he do that?
Shyam needs to pay school fees 40000 would he be allowed to pay
f)Shyam receives a payment and deposits 45000
g)Again he wants to make FD of 5000 for six months,Would he allowed.What is his total money now in both the accounts
*/

// i am assuming that this all happens in a single day
abstract class Account{
    private double Balance;  // if it is public it can be changed without deposit and withdraw 
    Account(double bal){
        Balance=bal;
    }
    Account(){
        // System.out.println("Default cconstructor called.");
    }
    public abstract boolean withdraw(double amount);
     public void deposit(double amount){
        Balance+=amount;
        System.out.println("Deposited ₹"+amount+" into your account.");
    };
    public double getBalance(){   // so that it can be accessed even if the main method is outside the package
        return Balance;
    }
}
class Current extends Account{
    static final double MIN_BAL=0;
    static final interest=0.5;
    private double overdraft_money=0;
    double overdraft;
    Current (double bal){
        super(bal);
        Balance=bal;
    }
    Current(){
        super(0);
        Balance=0;
    }
    public boolean withdraw(double amount){

        // Balance-=amount; 
        // if (Balance<0){
        //     overdraft=-(Balance);
        //     if (overdraft>MIN_BAL0){
        //         System.out.println("Overdraft limit ");
        //     }
        // }
        overdraft=(Balance+10000)-amount;
        if (overdraft<0){
            double x=-(overdraft);
            System.out.println("Overdraft limit exceeded.You cannot withdraw the money");
            System.out.println("You can withdraw only ₹"+x);
            System.out.println();
            return false;
        }
        else{
            Balance-=amount;
            return true;
        }
        if (Balance<0){
            overdraft_money+=(Balance*(1+interest));
        }

    }
    
}
class Savings extends Account{
    static final double MIN_BAL=1000;
    static final double interest=0.0825;
    double fd[]=new double[10];
    int count_fd=0;
    double transaction=0;
    double matured[]=new double[10];
    int year[]=new int[10];
    Savings(double bal){
        super(bal);
        Balance=bal;
    }
    Savings(){
        super(MIN_BAL);  // min bal is MIN_BAL
        Balance=MIN_BAL;
    }
    public boolean withdraw(double amount){
        if (transaction+amount>50000){
            System.out.println("Transaction limit for a day is ₹50,000.");
            System.out.println("Try again tomorrow.");
            return false;
            // transaction-=amount;
        }
        else{
            if (Balance-amount<MIN_BAL){
            System.out.println("Insufficient funds.");
            System.out.println("Your Balance is ₹"+Balance+" but you are trying to withdraw ₹"+amount);
            System.out.println();
            return false;
            } 
            else{
                System.out.println("₹"+amount+" was withdrawn from your account.");
                Balance-=amount;
                transaction+=amount;
                return true;
            }
        }
    }
    public boolean fixedDeposit(double amount,int years){  //date
        if (years<2){
            System.out.println("For Fixed deposit the minimum is 2 years");
            System.out.println("Please try again.");
            System.out.println();
            return false;
        }
        else{
            if (Balance-amount<MIN_BAL){
                System.out.println("Insufficient funds to make a fixed deposit of ₹"+amount);
                System.out.println("You can make a fixed deposit of ₹"+(Balance-MIN_BAL)+" or less.");
                System.out.println();
                return false;
                
            }
            else{
                System.out.println("Fixed deposit of ₹"+amount+" is successful.");
                Balance-=amount;
                count_fd++;
                double matured_amount=amount;
                for (int i=0;i<years;i++){
                    matured_amount=matured_amount*(1+interest);   
                }
                fd[count_fd-1]=amount;
                matured[count_fd-1]=matured_amount;
                year[count_fd-1]=years;
                return true;
            }
        }
    }
    void maturedAmount(double initial){
        for (int i=0;i<fd.length;i++){
            if (fd[i]==initial){
                System.out.println("The matured amount for a fixed deposit of ₹"+initial+"\nAfter "+year[i]+" is ₹"+matured[i]);
                // return matured[i];
                break;
            }
        }
    }
}

class preetam{
    public static void main(String[] args){
        Savings ram_savings=new Savings(10000);
        Current ram_current=new Current(500);
        ram_savings.deposit(20000);
        ram_current.deposit(60000);
        ram_savings.fixedDeposit(25000,3);
        ram_savings.maturedAmount(25000);
        Savings Shyam_saving=new Savings(40000);
        Current Shyam_current=new Current(20000);

    }
}