/**
 * Create an OrderProcessor class implementing Runnable that takes:
orderId, customerName, amount
When run, thread prints:
Processing order <orderId> for <customerName> of amount Rs.<amount>
Order <orderId> completed!

main() must:
Create 3 order threads
Start them using new Thread(...).start()
 */
public class p5 extends Thread{
    public static void main(String[] args) throws InterruptedException{
        OrderProcessor s1=new OrderProcessor(101,"Alex",9000);
        OrderProcessor s2=new OrderProcessor(102,"Bob",9634);
        OrderProcessor s3=new OrderProcessor(103,"Charlie",5485);

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
class OrderProcessor implements Runnable{
    int id, amount;
    String name;
    OrderProcessor(int id, String name,int amount){
        this.id=id;
        this.amount=amount;
        this.name=name;
    }
    public void run(){
        System.out.println("Processing order "+ id+" for " +name+"of amount Rs."+amount+"\n Order" + id+" completed!");
    }

}
