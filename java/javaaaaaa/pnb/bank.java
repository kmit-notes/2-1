/*Preetam National Bank allows current and savings account. all types of account can withdraw and deposit 
1. Current account has a overdraft facility which allow you to withdraw more  money than your balance.overdraft limit is only 10000.
2. It has an interest rate of only 5%
3. Current account does not let you have FIxed Deposit
4. There is no transaction limit
Whereas saving account needs to maintain 1000 balance, Fixed Deposit is allowed for minimum of 2 years , 
interest rate is 8.25% per annum. You can't remove money during the lock-in period.
Transactions limit is only 50000 more than that the bank does not allow to withdraw in a given day.
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

abstract class BankAccount{

    static final String bankname = "Preetam National Bank";
    String accHolderName;
    double bal;
    String accType;
    public BankAccount(String accHolderName, double bal, String accType) {
        this.accHolderName = accHolderName;
        this.bal = bal;
        this.accType = accType;
        System.out.println("Account created for " + accHolderName + " (" + accType + ") in " + bankname);
    }

    public void deposit(double amt) {
        bal += amt;
        System.out.println("Deposited " + amt + " to " + accHolderName + "'s " + accType + " account.");
    }

    abstract void withdraw(double amt);
    public double getbal() {
        return bal;
    }
    abstract void fd(double amt, int months);

}


class CurrentAcc extends BankAccount {
    static final double overdraft = 10000;
    double used = 0;
    static final double interest = 0.05;

    public CurrentAcc(String accHolderName, double bal) {
        super(accHolderName, bal, "Current");
    }
    @Override
    public void withdraw(double amt) {
    if (amt <= this.bal) {
        this.bal -= amt;
    } else if (amt <= (this.bal + overdraft - used)) {
        used += amt - this.bal;
        this.bal = 0;
    } else {
        System.out.println("Insufficient balance including overdraft");
    }
}
@Override
    public void fd(double amt, int months) {
        System.out.println("FD not allowed in Current Account");
}
}

class SavingsAcc extends BankAccount {
    static final double min = 1000;
    static final double limit = 50000;
    double daily = 0;
    static final double fd_interest = 0.0825;

    public SavingsAcc(String accHolderName, double bal) {
        super(accHolderName, bal, "Savings");
    }

    @Override
    public void withdraw(double amt) {
        if (amt <= (this.bal - min) && (daily + amt) <= limit) {
            this.bal -= amt;
            daily += amt;
            System.out.println(amt +" Withdrawn");
        } else {
            System.out.println("Transaction limit exceeded or insufficient balance");
        }
    }

    @Override
    public void fd(double amt, int months) {
        if (months < 24) {
            System.out.println("FD must be at least 2 years (24 months)");
            return;
        }
        if (amt > this.bal) {
            System.out.println("Insufficient balance to create FD");
            return;
        }
        if (fdCount >= fdAmounts.length) {
            System.out.println("Maximum number of FDs reached");
            return;
        }
        this.bal -= amt;
        fdAmounts[fdCount] = amt;
        fdMonths[fdCount] = months;
        fdCount++;

        System.out.println("FD of " + amt + " created for " + months + " months at 8.25% per annum");
    }

    public void showFDMaturities() {
        for (int i = 0; i < fdCount; i++) {
            double maturity = fdAmounts[i] * (1 + fd_interest * (fdMonths[i] / 12.0));
            System.out.println("FD " + (i + 1) + ": Principal = " + fdAmounts[i] + ", Maturity = " + maturity);
        }
    }
}
    