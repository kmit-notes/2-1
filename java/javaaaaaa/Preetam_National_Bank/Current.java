public class Current extends Account{
    public Current(String name,double amount){
        super(name,amount);
        
        
        }
        public void deposit(double amount){
            setBalance(getBalance()+amount);
            System.out.println(name + " deposited ₹" + amount + " (Current Account)");
    }
        
        private double overdraft_limit=10000;
        public boolean withdraw(double amount){
            if ((getBalance() - amount) + overdraft_limit > amount){
                setBalance(getBalance()-amount);
            System.out.println(name + " withdrew ₹" + amount + " (using overdraft if needed)");
            return true;
        } else {
            System.out.println("Withdrawal denied! Overdraft limit exceeded.");
            return false;


        }
        }
        
        double getInterest(){
        double interest =0.05;
        if(getBalance()<0){
            return getBalance() * interest;
        }
        else{
        return 0;
        }
        }
        void addInterest(){
            double balance=getBalance();
            if (balance > 0){
                setBalance(balance - getInterest());
            }
            else {
                System.out.println("Insufficient balance for interest");
            }
        }
        
    
    
}