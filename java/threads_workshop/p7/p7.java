/**
 * Question 7:

Create four thread classes, each performing a mathematical task:

Thread	Parameter	Task

T1	int n	factorial of n
T2	int n	check prime
T3	(a, b)	GCD of a and b
T4	double r	area of circle


main() must:

Create objects of each thread class with required parameters

Start the threads

Display the results inside each thread’s run() method
 */
public class p7 extends Thread{
    public static void main(String[] args) throws InterruptedException{
        Factorial s1=new Factorial(4);
        Prime s2=new Prime(7);
        GCD s3=new GCD(10,20);
        Area s4=new Area(5.0);

        Thread t1=new Thread(s1);
        Thread t2=new Thread(s2);
        Thread t3=new Thread(s3);
        Thread t4=new Thread(s4);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();

}
}
class Factorial implements Runnable{
    
    int n;
    Factorial(int n){
        this.n=n;
    }
    public void run(){
        int f=1;
        for ( int i=n;i>=1;i--){
            f*=i;
        }
        System.out.println("Factorial: "+f);
    }

}
class Prime implements Runnable{
    
    int n;
    
    Prime(int n){
        this.n=n;
    }
    public void run(){
        int c=0;
        for(int i=2;i<n;i++){
            if(n%i==0)
            c++;
        }
        if(c==0)
        System.out.println(n+ " is a prime number");
        else
        System.out.println(n+ " is NOT a prime number");
    }

}
class GCD implements Runnable{
    
    int n,m;
    GCD(int m, int n){
        this.n=n;
        this.m=m;
    }
    public void run(){
        int rem=m%n;
        while(rem != 0){
            m=n;
            n=rem;
            rem=m%n;

        }
        System.out.println("GCD: "+n);

        
    }

}
class Area implements Runnable{
    
    double n;
    Area(double n){
        this.n=n;
        
    }
    public void run(){
        
        
        System.out.println("Area: "+(3.14*n*n));

        
    }

}


