/*Create a class BankAccount with:
Fields: accountNumber, accountHolder, balance.
A static variable bankName (same for all accounts).
Constructor that initializes account details.
Methods: deposit(amount), withdraw(amount), displayAccount().
A static method to change the bank name.
👉 Extra Challenge:
Keep track of total number of accounts with a static counter.
Prevent overdrawing (balance can’t go below 0).
Write a test program that creates 3 accounts and modifies bankName in between—check how it affects all objects.*/


class BankAccount{
	int accountNumber;
	String accountHolder;
	float balance;
	static int counter=0;
	static String bankName;
	
	BankAccount(int accountNumber,String accountHolder,float balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountholder;
		this.balance=balance;
		counter++;
	}

	BankAccount(){
		counter++;
	}

	static void assign(String bankName){
		this.bankName=bankName;
	}

	float deposit(float amount){
		balance+=amount;
		return balance;
	}

	float withdraw(float amount){
		if (amount>(balance-1000)){
			println("Insufficient funds");
		}
		else{
			balance-=amount;
		}
		return balance;
	}
	
	float checkBalance(){
		return balance;
	}

	void displayAccount(){
		System.out.println("Bank name: "+bankName);
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Account Holder name: "+accountholder);
		System.out.println("Balance: "+checkBalance());
		System.out.println(""+);
		System.out.println(""+);

		
	}	
}








