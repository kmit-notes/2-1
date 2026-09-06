import java.io.File;
import java.io.FileWriter;

class fileTest{
    public static void main(String[] args) throws Exception{
        File f=new File("marks.csv");
        FileWriter fw= new FileWriter(f,true);
        fw.write("Ravi,");
        fw.write(35+",");
        fw.write(44+",");
        fw.write(22+",\n");
        fw.write("Ganga,");
        fw.write(34+",");
        fw.write(42+",");
        fw.write(26+",\n");
        fw.flush();
        fw.close();
    }
}