public class Main {
    public static void main(String[] args) {
        // Create users
        RegularCustomer ram = new RegularCustomer("Ram", 0);
        PremiumCustomer shyam = new PremiumCustomer("Shyam", 0);
        Merchant bigBazaar = new Merchant("BigBazaar", 0);

        // Deposit initial money
        ram.addMoney(5000);
        shyam.addMoney(5000);
        bigBazaar.addMoney(5000);

        // Transactions
        ram.pay(1200, bigBazaar);       // Ram pays BigBazaar
        shyam.pay(3000, bigBazaar);     // Shyam pays BigBazaar

        // Check balances and rewards
        System.out.println("Ram balance: ₹" + ram.getBalance());
        ram.earnRewards();

        System.out.println("Shyam balance: ₹" + shyam.getBalance());
        shyam.earnRewards();
        shyam.redeemRewards();
        System.out.println("Shyam balance after redeeming rewards: ₹" + shyam.getBalance());

        // Merchant reports
        bigBazaar.showTotalSales();
        bigBazaar.showTransactionHistory();
    }
}