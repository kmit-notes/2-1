import java.util.ArrayList;

public class Student1 {
    private String name;
    private int rollno;
    private String email;
    private String phno;
    public Student1(String name,int rollno,String email,String phno){
        this.name=name;
        this.rollno=rollno;
        this.email=email;
        this.phno=phno;
    }

    public int getRollno(){
        return rollno;
    }
    public String getPhno(){
        return phno;
    }
    public String getEmail(){
        return email;
    }
    
}
