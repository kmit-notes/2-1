public class Main {
    public static void main(String[] args) {
        // Ram's Accounts
        Savings ramSavings = new Savings("Ram", 10000);
        Current ramCurrent = new Current("Ram", 500);

        // Shyam's Accounts
        Current shyamCurrent = new Current("Shyam", 20000);
        Savings shyamSavings = new Savings("Shyam", 40000);

        ramSavings.deposit(20000);
        ramCurrent.deposit(60000);

        ramSavings.fixedDeposit(25000, 36);

        ramCurrent.withdraw(6000);
        ramCurrent.withdraw(4000);
        ramCurrent.withdraw(25000);

        ramCurrent.withdraw(20000);
        shyamSavings.deposit(20000);

        shyamSavings.withdraw(30000);

        shyamSavings.withdraw(40000);

        shyamSavings.deposit(45000);

        shyamSavings.fixedDeposit(5000, 6);

        System.out.println("\nFinal Balances");
        ramSavings.finalBal();
        ramCurrent.finalBal();
        shyamSavings.finalBal();
        shyamCurrent.finalBal();
    }
}