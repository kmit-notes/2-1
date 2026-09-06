class Bank3{
	String accHolderName;
	float balance;
	Bank3(String name,float balance){
		accHolderName=name;
		this.balance=balance;
	}
	Bank3(){
	}
	
	void deposit(float amount){
		balance+=amount;
	}
	void withdraw(float amount){
		if (amount>balance-1000){
			System.out.println("Insufficient Funds.\n");
			return;
		}
		balance-=amount;
	}
	float checkBalance(){
		return balance;
	}
}