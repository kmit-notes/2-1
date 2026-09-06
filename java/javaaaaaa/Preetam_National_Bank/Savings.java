import java.time.*;
public class Savings extends Account{
    private LocalDate lastTransactionDate;
    private double t=0;
    public Savings(String name,double amount){
        super(name,amount);
        lastTransactionDate=LocalDate.now();

    }
        public void deposit(double amount){
            setBalance(getBalance()+amount);
            System.out.println(name + " deposited ₹" + amount + " (Current Account)");
    }
        
        public boolean withdraw(double amount){
            
            LocalDate today = LocalDate.now();
            if (!today.equals(lastTransactionDate)) {
            t = 0;
            lastTransactionDate = today;
    }
            if (getBalance() - amount >= 1000 && t+amount <= 50000){
                setBalance(getBalance()-amount);
                t += amount;
            System.out.println(name + " withdrew ₹" + amount + " successfully.");
            return true;
        } else {
            System.out.println(name + " can't withdraw ₹" + amount + ". Either low balance or daily limit exceeded.");
            return false;
        }
           
        }
        
        boolean hasActiveFD=false;
        private LocalDate fdStartDate;
    private LocalDate fdMaturityDate;
    private double fdAmount = 0;
        public void fd(double amount,int years){
            double interest=0.0825;
            LocalDate fdStartDate = LocalDate.now(); // start date
            LocalDate fdMaturityDate = fdStartDate.plusYears(years);
            double maturityAmount = amount + (amount * interest * years);
        System.out.println(name + " started FD of ₹" + amount + " for " + years +
                " years. Maturity date: " + fdMaturityDate + ", Maturity amount: ₹" + maturityAmount);
            hasActiveFD = true;
            fdAmount=amount;


        }
        public void closeFD() {
        LocalDate today = LocalDate.now();
        if (hasActiveFD && !today.isBefore(fdMaturityDate)) {
            double interest = 0.0825;
            double maturityAmount = fdAmount + (fdAmount * interest * 
                (fdMaturityDate.getYear() - fdStartDate.getYear()));
            deposit(maturityAmount);
            hasActiveFD = false;
            System.out.println(name + "'s FD matured and ₹" + maturityAmount + " credited to account!");
        } else if (hasActiveFD) {
            System.out.println("FD still in lock-in period. Cannot close before " + fdMaturityDate);
        } else {
            System.out.println("No active FD to close.");
        }
    }
}