/*Radhika and Uma open a bank Account with 3000. Govt. decided to empower woman by putting 1500 in their account every month.
Radhika and Uma check their account after 3 years. What is the balance in their account.
Uma transfers 10,000 to Radhika for her marriage. Radhika wants to make 1,00,000 deposit for her new house.The bank mandates atleast Rs.1000 to be there in the bank.
At the end of all these transactions what is left in both of their accounts.*/

class ru{
	public static void main(String[] args){
		Bank b1,b2;
		b1=new Bank("Radhika");
		b2=new Bank("Uma");
		int month=3;
		b1.womenEmpower(month);
		b2.womenEmpower(month);
		System.out.printf("The balance in their account after %d is %.2f.\n",month,b1.checkBalance());
		b2.withdraw(10000);
		b1.deposit(10000);
		b1.withdraw(100000);  // insufficient funds
		System.out.printf("Radhika's account balance: %.2f\n",b1.checkBalance());
		System.out.printf("\nUma's account balance: %.2f\n",b2.checkBalance());
	}
}

