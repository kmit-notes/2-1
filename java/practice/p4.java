/*

Given an ArrayList of strings, remove duplicates without 
showing Set in output.
Use a Set internally but return the result as a List.
*/
import java.util.*;
class p4{
    public static void main(String[] args){
        ArrayList <String> a=new ArrayList<>();
        a.add("hello");
        a.add("world");
        a.add("today");
        a.add("yesterday");
        a.add("hello");
        System.out.println(a);
        
        HashSet <String> s=new HashSet<>(a);
        ArrayList <String> b=new ArrayList<>(s);
        System.out.println(b);
        
        
    }
}