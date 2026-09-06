public class A{
	
	static int counter=0;
	static A m1,m2;
	private A(){
	}
	
	public static A getInstance(){
		if (counter==0){
			counter++;
			m1=new A();
			return m1;
		}
		else if (counter==1){
			counter++;
			m2=new A();
			return m2;
		}
		else{
			System.out.println("Maximum 2 accounts allowed.Exceeds limit");
			return m2;
		}
	}
}