/*Task 1

Problem 1: Smallest integer with double the digits

given an integer N, returns the smallest integer greater than N  where the sum of its digits 
Ex
1.Given N=10, the function should return 11.

2.Given N=99, the function should return 9999.*/


import java.util.Scanner;

class p1{
	
	public static void main (String[] args){

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the value of N: ");
		int n = sc.nextInt();
		int og=n;

		int sum = 0;
		while(n>0){
	
			int k=n%10;
			sum+=k;
			n/=10;
		}
		n=og;
		int i=n+1;

		while (i>n){
			
			int sum_i=0;
             		
			int dupli=i;
			
			while(dupli>0){
	
				int j=dupli%10;
				sum_i+=j;
				dupli/=10;
			}

			if (sum_i==(2*sum)){

				System.out.println(i);
				break;
			}
			
			i++;
		}		
	}
}
