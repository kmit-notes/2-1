import java.io.*;
import java.util.*;

class image_copy {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);         
           int i=1;
           File f = new File("image.png");
            FileInputStream fis = new FileInputStream(f);
            File f1=new File("copy.png");
            FileOutputStream fos = new FileOutputStream(f1);
            int x=fis.read();
            while(x!=-1){
                fos.write(x);
                x=fis.read();
            }
            
            

            fis.close();
            fos.close();
    }
}


        
    
