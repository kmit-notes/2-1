/**
 * Question4:

Write a Java program where a thread processes student data:
(id, name, marks)
When run, thread prints:
Student <name> with ID <id> scored <marks> marks.
main() must:
Create 5 threads with different student objects
Start all threads
 */

public class p4 extends Thread{
    public static void main(String[] args) throws InterruptedException{
        Student s1=new Student(101,"Alex",90);
        Student s2=new Student(102,"Bob",96);
        Student s3=new Student(103,"Charlie",54);

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
class Student implements Runnable{
    int id, marks;
    String name;
    Student(int id, String name,int marks){
        this.id=id;
        this.marks=marks;
        this.name=name;
    }
    public void run(){
        System.out.println(id + " : "+ name + " : "+ marks);
    }

}