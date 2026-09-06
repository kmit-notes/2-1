/*Problem 2- Filling glasses with water.
There are N empty glasses with a capacity of 1, 2, ..., N liters (there is exactly one glass of each unique capacity). You want to pour exactly K liters of water into the glasses. Each glass may be either full or empty (a glass cannot be partially filled). What is the minimum number of glasses that you need to contain K liters of water?

Examples:
----------
1.Given N=5 and K=8, the function should return 2. There are five glasses with capacity 1, 2, 3, 4 and 5. You can use two glasses with capacity 3 and 5 to hold 8 liters of water.

2.Given N=4 and K=10, the function should return 4. You must use all the glasses to contain 10 liters of water.*/



import java.util.Scanner;

class p2{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the value of N: ");
		int n = sc.nextInt();

		System.out.print("Enter the value of K: ");
		int k = sc.nextInt();
		int og=k;

		int no_of_glasses=0;

		for (int i = n ; i > 0 ; i--){
			if (k-i==0 || k-i>0){
				no_of_glasses++;
				k=k-i;
			}

		}
		System.out.printf("\nThe minimum number of glasses that you need to contain %d liters of water is: %d",og,no_of_glasses);
		
	}
}