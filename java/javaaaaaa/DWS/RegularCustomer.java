class RegularCustomer extends DWS {
    private double cashback = 0;

    public RegularCustomer(String name, double balance) {
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

            if (amount > 1000) {
                cashback = amount * 0.005; // 0.5%
                balance += cashback;
                System.out.println(name + " earned cashback ₹" + cashback);
            }
        } else {
            System.out.println(name + " has insufficient balance!");
        }
    }

    @Override
    public void earnRewards() {
        System.out.println(name + " has no rewards.");
    }
}