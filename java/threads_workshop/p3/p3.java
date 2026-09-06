/**
 * Question 3:

Write a Java program where:
Thread-1 receives an integer array and computes the sum
Thread-2 receives a string and prints its reverse
Use constructors to pass data.
main() must:
Create Thread-1 with array {10, 20, 30, 40}
Create Thread-2 with string "Multithreading"
Start both threads
 */

public class p3 extends Thread{
          int[] arr={10,20,30,40};
    int sum=0;
    public void run(){
    for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        
    }
    System.out.println(sum);
}
    public static void main(String[] args) throws InterruptedException{
  
        p3 x=new p3();
        Thread t1=new Thread(x);
        RString r=new RString("Multithreading");
        Thread t2=new Thread(r);

        t1.start();
        t1.join();
        t2.start();
        t2.join();


        
    }
}
class RString implements Runnable{
    String s;
    RString (String s){
        this.s=s;
    }
    public void run(){
        for(int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
        }
    }

}

