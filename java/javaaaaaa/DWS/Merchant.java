class Merchant extends DWS {
    private double totalSales = 0;

    public Merchant(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void addMoney(double amount) {
        balance += amount;
        totalSales += amount;
        transactionHistory[transactionCount++] = "Received ₹" + amount;
    }

    @Override
    public void pay(double amount, DWS receiver) {
        // Merchants don't pay
    }

    @Override
    public void earnRewards() {
        // Merchants don't earn rewards
    }

    public void showTotalSales() {
        System.out.println(name + " total sales: ₹" + totalSales);
    }
}