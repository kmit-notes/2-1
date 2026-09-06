/*
Given the sentence: "Java is fun and Java is powerful"
Count the number of unique words, ignoring case.
Print the unique words in sorted alphabetical order.
*/
import java.util.*;
class p1{
    public static void main(String[] args){
        String s;
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        String arr[]=s.split(" ");
        TreeSet<String> hs= new TreeSet<>();
        for(String sa: arr){
            hs.add(sa.toLowerCase());
        }
        System.out.println(hs);
        //System.out.println(hs.size());
        
    }
}