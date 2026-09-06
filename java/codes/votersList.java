import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;

class votersList{
    public static void main(String[] args) throws Exception{
        File f=new File("votersList.csv");
        // FileWriter fw=new FileWriter(f,true);
        // String name;
        // int age;
        // String Gender;
        // char data=new char[1000];
        // Scanner sc=new Scanner(System.in);
        // for (int i=0;i<4;i++){
        //     System.out.print("Name: ");
        //     name=sc.next();
        //     System.out.print("Age: ");
        //     age=sc.nextInt();
        //     System.out.print("Gender: ");
        //     Gender=sc.next();
        //     if (age>18){
        //         fw.write(name+",");
        //         fw.write(age+",");
        //         fw.write(Gender+"\n");
        //     }
        //     else{
        //         System.out.println("Age should be above 18. could not write into file.");
        //     }
        // }

        // fw.flush();
        // fw.close();

        // FileReader fr=new FileReader(f);
        // // System.out.println(fr.read());
        // // fr.read();
        // int g=fr.read();
        // while (g!=-1){
        //     System.out.print((char)g);
        //     g=fr.read();
        // }

        // fw.flush();
        // fw.close();

        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        String j=br.readLine();
        while(j!=null){
            String data[]=j.split(",");
            if (data[2].equalsIgnoreCase("female")){
                System.out.println(data[0]);
            }
            j=br.readLine();
        }
    }
}