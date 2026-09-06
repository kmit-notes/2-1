import java.time.LocalDate;
import java.io.*;
class Employee implements Serializable{
    String emailId;
    int empId;
    int age;
    LocalDate birthdate;
    String name;


    public String toString(){
        return empId + " " + name;

    }
    Employee(int empId,LocalDate b, String name){
        this.empId=empId;
        birthdate = b;
        this.name= name;
        emailId=name+"@kmit.in";
        age=LocalDate.now().getYear() - b.getYear();

    }


}

