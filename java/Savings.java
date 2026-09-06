import java.util.ArrayList;

public class Savings extends Account {
    private double interestRate;
    private double maxWithdrawalLimit = 50000;
    private double fdInterestRate = 8.25;
    private ArrayList<FixedDeposit> fixedDeposits = new ArrayList<FixedDeposit>();

    public Savings(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    public void createFixedDeposit(double principal, int tenure) {
        try{
            super.withdraw(principal);
            FixedDeposit fd = new FixedDeposit(principal, tenure);
            fixedDeposits.add(fd);
            System.out.println("Fixed Deposit created: " + fd.toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Insufficient funds in savings account");
        }else if(amount > maxWithdrawalLimit) {
            System.out.println("Withdrawal amount exceeds the maximum limit of " + maxWithdrawalLimit);
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Interest Rate: " + interestRate + "%";
    }


    private class FixedDeposit {
        private double principal;
        private int tenure; 

        public FixedDeposit(double principal, int tenure) {
            this.principal = principal;
            if (tenure < 2) {
                throw new IllegalArgumentException("Tenure must be greater than 2 years");
            }   
            this.tenure = tenure;
        }

        public double calculateFinalValue() {
            return principal * Math.pow((1 + fdInterestRate / 100), tenure);
        }

        @Override
        public String toString() {
            return "Fixed Deposit - Principal: " + principal + ", Tenure: " + tenure + " years, Maturity Amount: " + calculateFinalValue();
        }
    };
}
