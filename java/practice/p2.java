/*
Ask user for two strings.
Convert them to a list of characters, sort them, 
and compare the lists to check if both strings have the same characters.
*/
import java.util.*;
class p2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        String s=sc.nextLine();
        String s1=sc.nextLine();
        
        char arr[]=s.toCharArray();
        char arr1[]=s1.toCharArray();
        
        ArrayList<Character> a1=new ArrayList<>();
        ArrayList<Character> a2=new ArrayList<>();
        
        for(char x:arr){
            a1.add(x);
        }
        for(char y:arr1){
            a2.add(y);
        }
        
        Collections.sort(a1);
        Collections.sort(a2);
        
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1.equals(a2));
        
        
    }
}