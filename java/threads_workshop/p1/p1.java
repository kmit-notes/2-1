/**
 * Question 1:

Write a Java program with a main method that:

Creates three threads, each printing the multiplication table of 3, 5, and 7.Pass the number to the thread through the constructor.

Implement using Runnable.
main() must:
Create objects of the Runnable class
Pass parameters (3, 5, 7)
Start three threads
********************************************************************
 */
public class p1{
    public static void main(String[] args) throws InterruptedException{
        Multiplication m1 = new Multiplication(3);
        Multiplication m2 = new Multiplication(5);
        Multiplication m3 = new Multiplication(7);
        Thread t1= new Thread(m1,"a");
        Thread t2= new Thread(m2,"b");
        Thread t3=new Thread(m3,"c");
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

    }

}
class Multiplication implements Runnable{
    int n;
    Multiplication(int n){
        this.n=n;
    }
    @Override
    public void run(){
        for(int i=0; i<=10;i++){
            System.out.println(n + "x" + i+ "=" + (i*n));

        }
    }
}