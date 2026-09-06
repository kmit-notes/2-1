class Bank2{
	String accHolderName;
	float balance;
	Bank2(String name,float balance){
		accHolderName=name;
		this.balance=balance;
	}
	Bank2(){
	}
	
	void deposit(float amount){
		balance+=amount;
	}
	void salary(float amount){
		for (int i=0;i<12;i++){
			this.balance=this.balance+amount;
		}
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