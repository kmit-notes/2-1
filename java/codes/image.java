import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class image{
    public static void main(String[] args) throws Exception{
        File f1 =new File("photo.png");
        File f2=new File("image.png");
        FileInputStream fi = new FileInputStream(f1);
        FileOutputStream fo = new FileOutputStream(f2);
        int g=fi.read();
        while(g!=-1){
            // System.out.print((char)g);
            fo.write(g);
            g=fi.read();
        }
        // fi.flush();
        fi.close();
        fo.flush();
        fo.close();
    }
}