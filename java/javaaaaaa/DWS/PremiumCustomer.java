class PremiumCustomer extends DWS {
    private double cashback = 0;
    private int rewardPoints = 0;

    public PremiumCustomer(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void addMoney(double amount) {
        balance += amount;
        transactionHistory[transactionCount++] = "Added ₹" + amount;
    }

    @Override
    public void pay(double amount, DWS receiver) {
        if (balance >= amount) {
            balance -= amount;
            receiver.addMoney(amount);
            transactionHistory[transactionCount++] = "Paid ₹" + amount + " to " + receiver.name;

            if (amount > 500) {
                cashback = amount * 0.015; // 1.5%
                balance += cashback;
                System.out.println(name + " earned cashback ₹" + cashback);
            }

            rewardPoints += (amount / 100) * 2; // 2 points per ₹100
        } else {
            System.out.println(name + " has insufficient balance!");
        }
    }

    @Override
    public void earnRewards() {
        System.out.println(name + " has " + rewardPoints + " reward points.");
    }

    public void redeemRewards() {
        double redeemCash = rewardPoints * 1; // 1 point = ₹1
        balance += redeemCash;
        System.out.println(name + " redeemed " + rewardPoints + " points for ₹" + redeemCash);
        rewardPoints = 0;
    }
}