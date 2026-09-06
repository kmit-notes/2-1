package bank;
class Bank{
	String accHolderName;
	float balance;
	String bankName;
	Bank(String name){
		bankName="SBI";
		balance=3000;
		accHolderName=name;
	}
	Bank(){
	}
	void deposit(float amount){
		balance+=amount;
	}
	void withdraw(float amount){
		if (amount>balance-1000){
			System.out.println("\nInsufficient funds.\n");
			return;
		}
		balance-=amount;
	}
	float womenEmpower(int years){
		int months=years*12;
		for (int i=0;i<months;i++){
			balance+=1500;	
		}
		return balance;
	}
	
	float checkBalance(){
		return balance;
	}
	
}