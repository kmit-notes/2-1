class Bank {
    static final String BankName = "Preetham National Bank";
    String name;
    String type;
    double bal;

    Bank(String name, String type, double bal) {
        this.name = name;
        this.type = type;
        this.bal = bal;
    }
    
    void finalBal() {
        System.out.println(this.name + "'s " + this.type + " Account balance: " + this.bal);
    }
}

class Savings extends Bank {
    double day_bal = 50000;
    static final double rate = 0.0825;
    static final int min_months = 24;

    Savings(String name, double bal) {
        super(name, "Savings", bal);
    }

    void newday() {
        this.day_bal = 50000;
    }

    void deposit(double amount) {
        this.bal += amount;
        System.out.println(amount + " credited to Savings");
    }

    void withdraw(double amount) {
        if ((this.bal - amount - 1000) >= 0) {
            if ((this.day_bal - amount) >= 0) {
                this.day_bal -= amount;
                this.bal -= amount;
                System.out.println("Withdrawn " + amount + " from Savings");
            } else {
                System.out.println("Daily withdrawal limit exceeded");
            }
        } else {
            System.out.println("Insufficient balance in Savings");
        }
    }

    void fixedDeposit(double amount, int months) {
        if (months >= min_months) {
            if ((this.bal - amount - 1000) >= 0) {
                this.bal -= amount;
                double fin_amount = amount + (amount * rate * months) / 12;
                System.out.println("FD created for " + amount + " for " + months + " months");
                System.out.println("Maturity Value: " + fin_amount);
            } else {
                System.out.println("Not enough balance for FD");
            }
        } else {
            System.out.println("FD not possible, minimum 24 months required");
        }
    }

}

class Current extends Bank {
    static final float intr = 0.05f;
    double over_draft = 10000;
    double over_draft_taken = 0;

    Current(String name, double bal) {
        super(name, "Current", bal);
    }

    void fixedDeposit(double amount, int months) {
        System.out.println("FD not allowed in Current Account");
    }

    void withdraw(double amount) {
        if ((this.bal - amount) >= 0) {
            this.bal -= amount;
            System.out.println("Withdrawn " + amount + " from Current");
        } else if (this.over_draft + (this.bal - amount) >= 0) {
            this.over_draft_taken = amount - this.bal;
            this.over_draft -= this.over_draft_taken;
            System.out.println("Withdrawn " + this.bal + " from Current and " 
                               + this.over_draft_taken + " from overdraft");
            this.bal = 0;
        } else {
            System.out.println("Insufficient balance including overdraft");
        }
    }

    void deposit(double amount) {
        if (this.over_draft_taken > 0) {
            double interest = this.over_draft_taken * intr;
            double totalDue = this.over_draft_taken + interest;

            System.out.println("Overdraft repayment due: " + totalDue);

            if (amount >= totalDue) {
                amount -= totalDue;
                System.out.println("Overdraft fully cleared!");
                this.over_draft += this.over_draft_taken;
                this.over_draft_taken = 0;
                this.bal += amount;
            } else {
                this.over_draft_taken -= amount;
                this.over_draft += amount;
                System.out.println("Partial overdraft repayment of " + amount);
                amount = 0;
            }
        } else {
            this.bal += amount;
        }
        System.out.println("Current balance: " + this.bal + ", Overdraft left: " + this.over_draft + ", Overdraft taken: " + this.over_draft_taken);
    }

    @Override
    void finalBal() {
        System.out.println(this.name + "'s Current Account balance: " + this.bal +" Overdraft left: " + this.over_draft +" Overdraft taken: " + this.over_draft_taken);
    }
}