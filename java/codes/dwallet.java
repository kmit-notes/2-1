/*A company is developing a digital wallet system that supports multiple types of users: regular customers, premium customers, and merchants. Each user type behaves differently when performing transactions like paying, adding money, and earning rewards.
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

Design the system so that common behavior is reused, and unique behaviors are customizable.*/

// Abstract base class
// Abstract base class representing a generic User in the digital wallet system
abstract class User {
    String name;
    double balance;
    String[] transactions = new String[100]; // Stores transaction history
    int txnCount = 0; // Keeps count of transactions

    // Constructor to initialize user's name and balance
    User(String name) {
        this.name = name;
        this.balance = 0;
    }

    // Adds a transaction message to the history
    void addTransaction(String msg) {
        transactions[txnCount] = msg;
        txnCount++;
    }

    // Deposits money into the user's wallet
    void deposit(double amount) {
        this.balance += amount;
        addTransaction("Deposited ₹" + amount);
    }

    // Displays current wallet balance
    void showBalance() {
        System.out.println(name + "'s Current Balance: ₹" + balance);
    }

    // Displays transaction history
    void transactionHistory() {
        System.out.println("Transaction History for " + name + ":");
        for (int i = 0; i < txnCount; i++) {
            System.out.println((i + 1) + ". " + transactions[i]);
        }
    }
}

// RegularCustomer class with cashback benefit
class RegularCustomer extends User {
    double cashback;

    // Constructor initializes name and cashback
    RegularCustomer(String name) {
        super(name);
        cashback = 0;
    }

    // Performs payment to a merchant with cashback condition
    void pay(double amount, Merchant merchant) {
        if (balance < amount) {
            System.out.println("Transaction failed. Not enough balance.");
            return;
        }

        // Apply any discount from merchant
        double finalAmount = merchant.applyDiscount(amount);

        // Deduct the amount from wallet and send payment
        balance -= finalAmount;
        merchant.receivePayment(finalAmount, this.name);

        System.out.println(name + " paid ₹" + finalAmount + " to " + merchant.name);
        addTransaction("Paid ₹" + finalAmount + " to " + merchant.name);

        // Cashback if payment is above ₹1000
        if (amount > 1000) {
            double cb = amount * 0.005;
            cashback += cb;
            balance += cb;
            System.out.println("Received Cashback: ₹" + cb);
            addTransaction("Received Cashback of ₹" + cb);
        }
    }

    // Display total cashback earned
    void showCashback() {
        System.out.println(name + "'s Total Cashback: ₹" + cashback);
    }
}

// PremiumCustomer with cashback and rewards
class PremiumCustomer extends User {
    double cashback;
    int rewardPoints;

    // Constructor initializes name, cashback, and rewards
    PremiumCustomer(String name) {
        super(name);
        cashback = 0;
        rewardPoints = 0;
    }

    // Performs payment to a merchant with cashback and reward benefits
    void pay(double amount, Merchant merchant) {
        if (balance < amount) {
            System.out.println("Transaction failed. Not enough balance.");
            return;
        }

        // Apply merchant discount
        double finalAmount = merchant.applyDiscount(amount);

        // Deduct final amount and send to merchant
        balance -= finalAmount;
        merchant.receivePayment(finalAmount, this.name);

        System.out.println(name + " paid ₹" + finalAmount + " to " + merchant.name);
        addTransaction("Paid ₹" + finalAmount + " to " + merchant.name);

        // Cashback if payment is above ₹500
        if (amount > 500) {
            double cb = amount * 0.015;
            cashback += cb;
            balance += cb;
            System.out.println("Received Cashback: ₹" + cb);
            addTransaction("Received Cashback of ₹" + cb);
        }

        // Earn 2 reward points per ₹100 spent
        int earnedPoints = (int) (amount / 100) * 2;
        rewardPoints += earnedPoints;
        System.out.println("Earned Reward Points: " + earnedPoints);
        addTransaction("Earned " + earnedPoints + " reward points");
    }

    // Display total cashback
    void showCashback() {
        System.out.println(name + "'s Total Cashback: ₹" + cashback);
    }

    // Display current reward points
    void showRewardPoints() {
        System.out.println(name + "'s Reward Points: " + rewardPoints);
    }

    // Redeem reward points for cashback (₹0.25 per point)
    void redeemRewards() {
        if (rewardPoints == 0) {
            System.out.println("No reward points to redeem.");
            return;
        }
        double rewardValue = rewardPoints * 0.25;
        balance += rewardValue;
        addTransaction("Redeemed " + rewardPoints + " points for ₹" + rewardValue);
        System.out.println("Redeemed " + rewardPoints + " points for ₹" + rewardValue);
        rewardPoints = 0;
    }
}

// Merchant class who can receive payments, apply discounts, and track sales
class Merchant extends User {
    double totalSales;

    // Constructor initializes name and total sales
    Merchant(String name) {
        super(name);
        totalSales = 0;
    }

    // Applies discount of ₹50 for purchases above ₹1000
    double applyDiscount(double amount) {
        if (amount > 1000) {
            System.out.println("Discount Applied: ₹50");
            return amount - 50;
        }
        return amount;
    }

    // Receives payment from a customer and updates total sales
    void receivePayment(double amount, String from) {
        balance += amount;
        totalSales += amount;
        addTransaction("Received ₹" + amount + " from " + from);
    }

    // Displays total sales received
    void showTotalSales() {
        System.out.println(name + "'s Total Sales: ₹" + totalSales);
    }
}

// Main class to demonstrate the digital wallet system
public class dwallet {
    public static void main(String[] args) {
        // Create users
        RegularCustomer ram = new RegularCustomer("Ram");
        PremiumCustomer shyam = new PremiumCustomer("Shyam");
        Merchant bigBazaar = new Merchant("BigBazaar");

        // Deposit ₹5000 to each wallet
        ram.deposit(5000);
        shyam.deposit(5000);
        bigBazaar.deposit(5000); // Optional: Merchant starting balance

        System.out.println("\n--- Transactions Start ---\n");

        // Ram makes a payment of ₹1200 to BigBazaar
        ram.pay(1200, bigBazaar);

        // Shyam makes a payment of ₹3000 to BigBazaar
        shyam.pay(3000, bigBazaar);

        System.out.println("\n--- Status Check ---\n");

        // Ram checks cashback and balance
        ram.showCashback();
        ram.showBalance();

        // Shyam checks cashback, reward points, and balance
        shyam.showCashback();
        shyam.showRewardPoints();
        shyam.showBalance();

        // Shyam redeems his reward points
        shyam.redeemRewards();
        shyam.showBalance();

        // BigBazaar checks total sales and transaction history
        bigBazaar.showTotalSales();
        bigBazaar.transactionHistory();
    }
}
