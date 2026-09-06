/*
Preetam National Bank allows current and savings account. all types of account can withdraw and deposit 
1. Current account has a overdraft facility which allow you to withdraw more  money than your balance.
2. It has an interest rate of only 5%
3. Current account does not let you have FIxed Deposit
4. There is no transaction limit
Whereas saving account needs to maintain 1000 balance, Fixed Deposit is allowed for minimum of 2 years , 
interest rate is 8.25% per annum. You can't remove money during the lock-in period.
Transactions limit is only 50000 more than that the bank does not allow to withdraw in a given day.
overdraft limit is only 10000
a)Ram opens 2 accounts in the bank, one savings with 10000 and current with 500 only.
Shyam opens 2 account in the same bank, current account with 20000 and 40000 in savings account.
b)Ram is businessman whose needs to do a lot of transactions in a single day. Ram deposits 20000 in savings account and 60000 in current account
c)He makes an FD for 25000 for 3 years
d)Ram needs to pay 6000 to paper vendor.
4000 to canteen guy, 25000 to transport.
Ram transfers 20000 to Shyam . Can he transfer?
is Ram allowed to make an FD?
What would be his amount when it matures.
e)Shyam needs to send 30000 to his sister. How can he do that?
Shyam needs to pay school fees 40000 would he be allowed to pay
f)Shyam receives a payment and deposits 45000
g)Again he wants to make FD of 5000 for six months,Would he allowed.What is his total money now in both the accounts



*/
abstract class Account{
    double balance;//can also make private
    String name;
   abstract void deposit(double am);//public
    abstract void withdraw(double am);//public
    final void showBalance(){
        System.out.println(this.name +" You Have Balance of Rs. "+this.balance+"\n");
    }
    Account(String n,double bal){
        this.balance = bal;
        this.name = n;
    }
    
}
        
        
class current extends Account{
    current(String n,double bal){
        super(n,bal);
    }
    static final double interest = 0.05;
    static final int  o_limit= -10000;
    void deposit(double am){
        if(this.balance<0){
            this.balance = am + (this.balance)*1.05;
            showBalance();
        }
        else{
            balance+=am;
            showBalance();
        }
    }
    void withdraw(double am){
        if(this.balance-am>o_limit){
        balance-=am;
        }
        else{
             System.out.println("Withdraw not possible, exceeding limit.");
        }
    }

    
    
}
class saving extends Account{

    static final double rate = 0.0825;//we can also use intializer static\
    static final int max_limit=50000;
    
    saving(String n,double bal){
        super(n,bal);
    }

    void deposit(double am){
        balance+=am;
        showBalance();
    }
    void withdraw(double am){
        if(am>max_limit){//Transaction Limit
            System.out.println("Transaction amount greater than 50k");  
        }
        else if(am<=balance-1000){
            balance-=am;
        }
        else{
            System.out.println("Withdraw Not possible");
        }
    }

   public void fd(double amt,double t){//Fixed Deposit rtype can be boolean  array of fd's
   //No lock-in method use date
        if(t<2){
            System.out.println("FD Not possible Try for more than 2 years!");
        }
        else{
            if(amt<balance-1000){
            this.balance -= amt;
            amt = amt + (amt*rate)*t;//maturity amount
            balance += amt;
            System.out.println(this.name +" money after fd: "+this.balance);
            }
            else{
                System.out.println("Not Enough Funds");
            }
        }
   }
   
}

class bank{
    public static void main(String[] args){
        //a)
        current ram_c = new current("Ram",500);
        saving ram_s = new saving("Ram",10000);

        current shyam_c = new current("Shyam",20000);
        saving shyam_s = new saving("Shyam",40000);

        //b)
        ram_s.deposit(20000);
        ram_c.deposit(60000);

        //c)
        
        ram_s.fd(25000,3);
      

        //d) we use current account
        ram_c.withdraw(6000);
        ram_c.withdraw(4000);
        ram_c.withdraw(25000);//Yes Shyam is allowed to do fd
        //Ram paying shyam
        ram_c.withdraw(20000);//there should be a case such that withdraw unsuccrsfull but next depost will happen next make a
        shyam_c.deposit(20000);

        //e) shyam sends 
        if(shyam_s.balance>30000){
            shyam_s.withdraw(30000);
            System.out.println("Shyam Can send from his savings account");
            shyam_s.showBalance();
        }
        else{
            shyam_c.withdraw(30000);
            System.out.println("Shyam Can send from his Current account");

        }
        

        // shyam shall pay 40000 school fee
        if(shyam_s.balance>40000){
            shyam_s.withdraw(40000);
            System.out.println("Shyam Can send from his savings account");
            
        }
        else{
           
            shyam_c.withdraw(40000);
             shyam_c.showBalance();
            
        }

        //f) shyam recieves 45000
        shyam_c.deposit(45000);

        //g) fd for 6months,total money shyam

        shyam_s.fd(5000,0.5);

        shyam_c.showBalance();
        shyam_s.showBalance();

        
        


        

    }
}
