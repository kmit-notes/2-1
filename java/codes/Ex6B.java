/*
You have created a web-based survey of favorite programming languages and are 
capturing the results into a text file named "logfile.txt".
The logfile is ordered by increasing timestamp. You are concerned that some 
people are voting multiple times for the same item. To somewhat address this problem, 
throw out any new votes for the same item that come from the same IP address 
within 20 seconds.

logfile.txt  (sample)
-----------
PHP	137.229.156.12	1000002
C#	137.229.156.18	1000005
PHP	137.229.156.12	1000006
Prolog	156.213.38.31	1000010
PHP	128.120.56.214	1000020
PHP	137.229.156.12	1000022

In the above example, the second and last votes for PHP would be thrown out 
because they are for the same item from the same IP address and occur within 
20 seconds of other PHP votes from the same IP address. 
However, the PHP vote from 128.120.56.214 would be retained since there is not 
another PHP vote from this IP address.
Write a Java program to count the votes from the logfile, throwing out 
duplicate votes using the rules above. Display the votes in a table, 
as shown below for the 

Output=
PHP 2 
C# 1
Prolog 1

*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Ex6B {
    public static void main(String[] args) throws Exception{
        Map<String,String> m1=new HashMap<>();
        File f=new File("logfile.txt");
        // f.createNewFile()
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        String c;
        c=br.readLine();
        while (c!=null){
            String[] arr=c.split("\t");
            // Integer x=new Integer(arr[1]);
            // System.out.println(x);
            // System.out.println(c);
            m1.put(arr[1],arr[0]);

            c=br.readLine();
        }
        System.out.println(m1);
    
        for (String x:m1.keySet()){
            String y=m1.get(x);
            int count=0;
            for (String z:m1.keySet()){
                if (y.equals(m1.get(z))){
                    count++;
                }
            }
            System.out.println(y+" "+count);
        }
    }
}

