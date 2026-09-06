/*
Given the string "swiss", find the first character that does not repeat.
Expected output: w

*/
import java.util.*;
class p5{
    public static void main(String[] args){
        String s;
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        char c[]=s.toCharArray();
        HashMap<Character,Integer> h=new HashMap<>();
        for(char x:c){
            int i=h.getOrDefault(x,0)+1;
            h.put(x,i);
            
            
            
        }
        for(char i:h.keySet()){
            if(h.get(i)==1){
            System.out.println(i);
            break;}
            
        }
        
        
    }
}