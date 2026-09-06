import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class desar {
    public static void main(String[] args) throws Exception{
        FileInputStream fis=new FileInputStream("Sam.ser");
        ObjectInputStream oi=new ObjectInputStream(fis);
        Employee e=(Employee)oi.readObject();
        System.out.println(" "+e.name+" "+" "+e.id);
    }
}
