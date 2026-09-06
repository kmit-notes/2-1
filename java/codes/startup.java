/*A startup ("TechCo") opens with ₹1,00,000.
It has 2 employees (Esha & Kunal) who each earn ₹20,000 monthly.
The company makes ₹70,000 sales revenue every month from customers.
Every 2 months, it pays ₹15,000 for raw materials to a supplier.
It pays 10% GST tax on monthly revenue to Govt.
In month 6, customer demands a refund of ₹10,000*/

class startup{
	public static void main(String[] args){
		Bank3 c,e1,e2;
		c=new Bank3("TechCo",100000);
		float monthlyRevenue=70000;
		
		//initially let esha and kunal have 0 amount in their account
		e1=new Bank3("Esha",0);
		e2=new Bank3("kunal",0);
		
		//let us consider a duration of a year
		//It has 2 employees (Esha & Kunal) who each earn ₹20,000 monthly.
		//The company makes ₹70,000 sales revenue every month from customers.

		for (int i=0;i<12;i++){
			c.deposit(70000);
			c.withdraw(40000);
			e1.deposit(20000);
			e2.deposit(20000);
			
		}

		//Every 2 months, it pays ₹15,000 for raw materials to a supplier.
		for (int i=0;i<12;i+=2){
			c.withdraw(15000);
		}
	

		//It pays 10% GST tax on monthly revenue to Govt.
		float gst = (float)(0.1*monthlyRevenue);
		for (int i=0;i<12;i++){
			c.withdraw(gst);
		}
 		
		
		//In month 6, customer demands a refund of ₹10,000
		c.withdraw(10000);
		
		System.out.println("Company's Balance: "+c.checkBalance());
		System.out.println("Esha's Balance: "+e1.checkBalance());
		System.out.println("Kunal's Balance: "+e2.checkBalance());
		
	}
}