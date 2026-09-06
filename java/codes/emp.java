import java.util.*;
import java.io.BufferedReader;
// import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable{
    int id;
    double salary;
    String name;
    transient String dept;
    double rating;
    Employee(int id,double salary,String name,double rating){
        this.dept="water works";
    }

}
public class emp {
    public static void main(String[] args) throws Exception {
        File f=new File("emp.csv");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        // List<String> all=fr.readAllLines();
        // for (String x:all){
        //     String ex[]=x.split(",");
        //     for (int i=0;i<ex.length;i++){
        //         if (Double.parseDouble((ex[ex.length-1]))>4.0){
        //             Employee e=new Employee(Integer.parseInt(ex[0]),Double.parseDouble(ex[1]),ex[2],Double.parseDouble(ex[ex.length-1]));
        //             e.salary+=(0.2*e.salary);
        //             FileOutputStream fos=new FileOutputStream(e.id+".ser");
        //             ObjectOutputStream ob=new ObjectOutputStream(fos);
        //             ob.writeObject(e);
        //             ob.flush();
        //             ob.close();
        //         }
        //     }
        // }
        String j=br.readLine();
        while(j!=null){
            String dum[]=j.split(",");
            Employee e=new Employee(Integer.parseInt(dum[0]),Double.parseDouble(dum[1]),dum[2],Double.parseDouble(dum[dum.length-1]));
            if (e.rating>4.0){
                e.salary+=(0.2*e.salary);
                FileOutputStream fos=new FileOutputStream(e.id+".ser");
                ObjectOutputStream ob=new ObjectOutputStream(fos);
                ob.writeObject(e);
                ob.flush();
                ob.close();
            }
            j=br.readLine();
        }
        fr.close();
    }
}
