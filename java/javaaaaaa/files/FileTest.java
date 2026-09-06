import java.io.*;
import java.io.IOException;
import java.util.*;
class FileTest {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);         
           int i=1;
           File f = new File("vote.csv");
            FileWriter fw = new FileWriter(f);
           while(i<2){
            String name=sc.next();
            int age=sc.nextInt();
            String gender=sc.next();
            if(age>18)
            {
                fw.write(name+","+age+","+gender+","+"\n");
            }
            i++;
           } 
           fw.flush();
           fw.close();
           FileReader fr= new FileReader(f);
           
        /**int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);  // convert ASCII to character
        }
        fr.close();**/
    
        
        BufferedReader br=new BufferedReader(fr);
        String j=br.readLine();
        while(j != null){
            String data[]=j.split(",");
            if(data[2].equalsIgnoreCase("female")){
                System.out.println(data[0]);
            }
            j=br.readLine();
        }
        fr.close();
    }
}
