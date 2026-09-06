import java.io.*;
public class testemp{
    public static void main(String[] args){
        //Task1: Read data from csv and create objects of Employee
        //Task2: Increase the salary by 20% only if rating >4
        //Task 3: Serialize the increased salary employees
        //Task 4: Deserialize the employees and display their empId, name and sal
        File f=new File("emps.csv");
        FileReader fr= new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        String j=br.readLine();
        while(j!=null){
            String a[]=j.split(",");
            Employee e=new Employee(Integer.parseInt(a[0]),a[2],Float.parseFloat(a[1]) ,Float.parseFloat(a[4]));
            
            if(e.rating > 4.0){
                e.salary+=(e.salary*.2);
                //serialize
                FileOutputStream fe = new FileOutputStream(e.name+ ".ser");
                ObjectOutputStream ob=new ObjectOutputStream(fe);
                ob.writeObject(e);
            }
            j=br.readLine();
        }
        //deserialize
        
        
    }
}