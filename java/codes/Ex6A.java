/*
Write a java program that loads names and phone numbers from the 'Phonebook.txt' 
text file into HashTable where data is organized as one line per record and each 
field in record are separated by a tab(\t). It takes a name or phone number as 
input and prints the corresponding other value from hash table.

Sample IO: 1
------------
Enter name: Nobitha
Mobile number is 345678
Enter mobile number: 123456
Name is Tom

Sample IO: 2
------------
Enter name: John                                                                                                        
Mobile number is 667788                                                                                                 
Enter mobile number: 889767                                                                                             
Not Found

Sample Phone book (Phonebook.txt)
-----------------
John	667788
Nobitha	345678
Tom	123456
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex6A {
    public static void main (String[] args) throws Exception{
        Map<String,Integer> m1=new HashMap<>();
        File f=new File("Phonebook.txt");
        // f.createNewFile()
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        String c;
        c=br.readLine();
        while (c!=null){
            String[] arr=c.split("\t");
            Integer x=new Integer(arr[1]);
            // System.out.println(x);
            // System.out.println(c);
            m1.put(arr[0],x);
            c=br.readLine();
        }

        // System.out.println(m1);

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name: ");
        // Enter name: Nobitha
        String name=sc.next();
        for (String x:m1.keySet()){
            if ((name.toLowerCase()).equals(x.toLowerCase())){
                System.out.println("Mobile number is "+m1.get(x));
            }
        }
        
        System.out.print("Enter mobile number: ");

        int num=sc.nextInt();

        for (String x:m1.keySet()){
            if (num==m1.get(x)){
                System.out.println("Name is "+x);
            }
        }
// Mobile number is 345678
// Enter mobile number: 123456
// Name is Tom
        
    }
}
