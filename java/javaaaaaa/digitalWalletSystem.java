/*
A company is developing a digital wallet system that supports multiple types of users: regular customers, premium customers, and merchants.
Each user type behaves differently when performing transactions like paying, adding money, and earning rewards.
Some operations like transaction history and wallet balance should be common to all.
Regular Customer

Earns 0.5% cashback on every transaction above ₹1000

Cannot earn reward points

No additional benefits
Premium Customer

Earns 1.5% cashback on every transaction above ₹500

Earns 2 reward points per ₹100 spent

Can redeem reward points for cashback
Merchant

Can receive payments from customers

Can issue discounts (like ₹50 off for purchases above ₹1000)

Can generate sales reports (total payments received)

Does not earn cashback or rewards

Create one object each for:

A regular customer (e.g., Ram)

A premium customer (e.g., Shyam)

A merchant (e.g., BigBazaar)

Deposit ₹5000 to each user's wallet.

Ram pays ₹1200 to BigBazaar.

Shyam pays ₹3000 to BigBazaar.

Ram checks his cashback and balance.

Shyam checks his cashback, reward points, and balance.

Shyam redeems reward points.

BigBazaar views the total sales and transaction history.

Design the system so that common behavior is reused, and unique behaviors are customizable.


*/
abstract class digitalWallet{
    String name;
    double balance;
    
    digitalWallet(String name){
        this.name=name;
        this.balance=0;
        
    }
    abstract void pay(double amount, digitalWallet receiver);
    abstract void add(double amount);
    abstract void rewards();
    
    void viewBalance(){
        System.out.println(name+" Balance: "+balance);
        
    }
    void transactionHistory(){
        System.out.println("th");
    }
}
class regular extends digitalWallet{
   
    regular(String name){
        super(name);
    }
    void pay(double amount, digitalWallet receiver){
        if(balance >= amount){
        balance-=amount;
        receiver.add(amount);
        if(amount>1000){
            add(amount*0.005);
        }
    }
    else{
        System.out.println("Insufficient balance");
        
    }
    }
    void add(double amount){
        balance+=amount;
    }
    void rewards(){
        System.out.println("No rewards for this type.");
    }
}
class premium extends digitalWallet{
   int rewardp=0;
    premium(String name){
        super(name);
        
    }
    void pay(double amount, digitalWallet receiver){
        if(balance >= amount){
            balance-=amount;
        receiver.add(amount);
        if(amount>500){
            add(amount*0.015);
        }
        int points=(int)((amount/100)*2);
        rewardp+=points;
        System.out.println("Earned "+points+" points");
    }
        else{
            System.out.println("Insufficient balance");
        }
    }
    void add(double amount){
        balance+=amount;
    }
    void rewards(){
        System.out.println(rewardp+" reward points");
    }
    void rewards(int redeemp){
        if(redeemp <= rewardp){
            balance +=redeemp;
            rewardp -= redeemp;
            System.out.println("redeemed points: "+redeemp);
            
        }
        else{
            System.out.println("Insufficient points");
        }
        
    }
}
class merchant extends digitalWallet{
   int totalPayments=0;
    merchant(String name){
        super(name);
        
        
    }
    void pay(double amount, digitalWallet receiver){
        System.out.println("no pay");
        }
        
    
    void add(double amount){
        balance+=amount;
        totalPayments+=1;
    }
    void rewards(){
        System.out.println("No rewards for this type.");
    }
    void viewSales(){
        System.out.println(totalPayments+" payments received");
    }
    double discount(double purchaseamt){
        if(purchaseamt >1000) return purchaseamt-50;
        return purchaseamt;
    }
    
}
class test{
    public static void main(String[] args){
        regular ram=new regular("Ram");
        ram.add(5000);
        merchant BigBazaar=new merchant("BigBazaar");
        BigBazaar.add(5000);
        double amt=BigBazaar.discount(1200);
        ram.pay(amt, BigBazaar);
        ram.viewBalance();
        ram.rewards();
        BigBazaar.viewBalance();
        BigBazaar.viewSales();
        
        premium shyam=new premium("Shyam");
        shyam.add(5000);
        amt=BigBazaar.discount(1200);
        shyam.pay(amt,BigBazaar);
        shyam.viewBalance();
        //shyam.rewards();
        BigBazaar.viewBalance();
        BigBazaar.viewSales();
        
    }
}