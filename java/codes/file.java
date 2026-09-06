import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

class Employee implements Serializable{
    int id;
    String name;
    LocalDate dob;
    String dept;
    double salary;
    String emailID;
    // Employee(String name,int id,String dept,double salary){
    //     this.name=name;
    //     this.id=id;
    //     this.dept=dept;
    //     this.salary=salary;
    // }
    Employee(int id,LocalDate b,String name){
        this.id=id;
        dob=b;
        this.name=name;
        emailID=name+"@gamil.com";
    }
    public String toString(){
        return id+" "+name;
    }

}


public class file {
    public static void main(String[] args) throws Exception{
        Employee e=new Employee(1, LocalDate.of(1998, 12, 2), "Sam");
        FileOutputStream fos=new FileOutputStream(e.name+".ser");
        ObjectOutputStream ob=new ObjectOutputStream(fos);
        ob.writeObject(e);
        ob.flush();
        ob.close();
    }
}

// public class Deser{
//     public static void main(String[] args) {
//         FileInputStream fis=new FileInputStream("Kiran.ser");
//         ObjectInputStream oi=new ObjectInputStream(fis);
//         Employee e=(Employee)oi.readObject()
//         System.out.println(" "+e.name+" "+" "+e.id);
//     }
// }

/*output and input different streams 
 * the java obj containing four other java obj is converted into binary obj
 * binary data images can be put into the database
 * select where and or cant be used on binary column
 * when you dont want to change the java obj then we store it as binary data as obj
 * if want to make changes then we use tables and queries
 * the process of converting a java obj into a bite stream is called serialization. 
 * 
 * WHY IS THERE A NEED OF SERIALIZATION:
 * (when i dont want to change the java obj and perform queries
 * ping when we want to transfer the java objects from one jvm to another it is transferred as bite stream (hence serialization)
 * when there is an error or the system fails the bite stream file is still present and the obj can be reconstructed from that file)
 * whenever a java obj needs to be preserved (database ,tranporting from 1 jvm to another, exeption handling, etc) 
 * you will convert a java obj into a bite stream
 * for transportation and security purpose also
 * 
 * deserialization: bite stream-->obj.
 * sid ablumn artist time song(mp3 in binary)
 * we can get the song/mp3 file from one folder to another folder using file input and output stream
 * file input , delete on exit file output (for cut and paste)
 * object input stream --> reading and converting to bite stream       ---> for java objects
 * object output stream --> takes and writes the bit stream
 * 
 * resources-->  file,database,network
 * 
 * 
 * 
 */



 /*
Read the data from the file and if the rating is greater than 4 increase the salary by 20% .

1,2000,sachin,water works,4.5
11,3000,sachin,water works,4.2
12,4000,sachin,water works,4.0
14,2100,sachin,water works,3.5
11,2900,sachin,water works,2.5


*/