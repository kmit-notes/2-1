/*
Write a Java program to fill the below pattern into a square matrix:
The matrix has to be filled with numbers starting from 1. It has to start fill first row last column, last
row (reverse), first column (reverse) and so on.
n = 5
 1   2   3   4   5
16  17  18  19   6
15  24  25  20   7
14  23  22  21   8
13  12  11  10   9

Order of filling:
	1.	Top row → left to right
	2.	Right column → top to bottom
	3.	Bottom row → right to left
	4.	Left column → bottom to top
	5.	Repeat the same steps for the inner square
*/

import java.util.*;

public class pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] a = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {

            // 1. Top row (left → right)
            for (int i = left; i <= right; i++) {
                a[top][i] = num++;
            }
            top++;

            // 2. Right column (top → bottom)
            for (int i = top; i <= bottom; i++) {
                a[i][right] = num++;
            }
            right--;

            // 3. Bottom row (right → left)
            for (int i = right; i >= left; i--) {
                a[bottom][i] = num++;
            }
            bottom--;

            // 4. Left column (bottom → top)
            for (int i = bottom; i >= top; i--) {
                a[i][left] = num++;
            }
            left++;
        }

        // Printing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }
    }
}