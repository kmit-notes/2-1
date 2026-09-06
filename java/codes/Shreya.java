/*Shreya starts with ₹20,000 in her account. She earns ₹50,000 salary every month. She pays ₹15,000 rent every month.
Arjun starts with ₹5,000. He takes a loan of ₹60,000 from Shreya.
Arjun repays the loan in 12 monthly installments of ₹5,500 (includes interest).
Shreya also gets cashback rewards of ₹500 every 3 months.*/

class Shreya{
	public static void main(String[] args){
		Bank2 s,a;
		s=new Bank2("Shreya",20000);
		a=new Bank2("Arjun",10000);
		
		//System.out.println("Shreya's account balance is: "+s.checkBalance());
		//System.out.println("Arjun's account balance is: "+a.checkBalance());

		//shreya earns 50000 salary and pays 15000 rent consider 1 year then

		s.salary(50000);
		for (int i=0;i<12;i++){
			s.withdraw(15000);
		}
		
		//arjun took a loan of 60000 from shreya
		s.withdraw(60000);
		a.deposit(60000);

		//Arjun repays the loan in 12 monthly installments of ₹5,500
		for (int k=0;k<12;k++){
			a.withdraw(5500);
			s.deposit(5500);
		}
		
		//Shreya also gets cashback rewards of ₹500 every 3 months.
		for(int j=0;j<12;j+=3){
			s.deposit(500);
		}
		
		System.out.println("Shreya's account balance is: "+s.checkBalance());
		System.out.println("Arjun's account balance is: "+a.checkBalance());
	}
}