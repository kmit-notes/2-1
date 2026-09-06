/**
 * Question2:
Write a Java program where:
A class TaskThread extends Thread
The constructor accepts a taskName
When run, it prints:
<taskName> started by <thread-name>
<taskName> running...
<taskName> completed by <thread-name>

main() must:
Create three threads for tasks:
“File Upload”
“Data Backup”
“Log Cleanup”
Start all threads
*********************************************************************
 */
public class p2 extends Thread{
    String name;
    p2(String name){
        this.name=name;
    }
    public void run(){
        System.out.println(name+"Started by "+ Thread.currentThread().getName());
    }
    public static void main(String[] args) throws InterruptedException{
        p2 c=new p2("File Upload");
        p2 c1=new  p2("Data Backup");
        p2 c2=new p2("Log Cleanup");
        Thread t1=new Thread(c);
        Thread t2=new Thread(c1);
        Thread t3=new Thread(c2);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        System.out.println("Exited successfully");
        
    }
}
class TaskThread extends Thread{

}