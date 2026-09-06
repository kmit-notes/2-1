public class Test{
    public static void main(String[] args){
        Savings Rams = new Savings("Ram",10000);
        Current Ramc = new Current("Ram",500);

        Savings Shyams = new Savings("Shyam",10000);
        Current Shyamc = new Current("Shyam",500);

        Rams.deposit(20000);
        Ramc.deposit(60000);

        Rams.fd(25000,3);
        Rams.withdraw(6000);
        Rams.withdraw(4000);
        Rams.withdraw(25000);
        Rams.withdraw(20000);

        Shyams.deposit(20000);
        Shyams.withdraw(30000);
        Shyams.withdraw(40000);
        Shyams.deposit(45000);
        Shyams.fd(5000,1);
        
        
        
        



    }
}