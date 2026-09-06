/**
 * Question 6:

Create a TaskRunner class with parameter taskType:

"email" → print "Sending Email"

"sms" → print "Sending SMS"

"push" → print "Sending Push Notification"


main() must:

Create 3 threads with three different types

Start the threads
 */
public class p6 extends Thread{
    public static void main(String[] args) throws InterruptedException{
        TaskRunner s1=new TaskRunner("email");
        TaskRunner s2=new TaskRunner("sms");
        TaskRunner s3=new TaskRunner("push");

        Thread t1=new Thread(s1);
        Thread t2=new Thread(s2);
        Thread t3=new Thread(s3);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

}
}
class TaskRunner implements Runnable{
    
    String name;
    TaskRunner(String name){
        this.name=name;
    }
    public void run(){
        if(name == "push"){
            System.out.println("Sending Push Notification");
        }
        else
        {
            System.out.println("Sending "+ name);
        }
    }

}