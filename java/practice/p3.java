/*
Write code to count frequency of each character in "mississippi".
Expected output example: {m=1, i=4, s=4, p=2}


*/
import java.util.*;
class test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s;
        s=sc.nextLine();
        char c[]=s.toCharArray();
        HashMap<Character,Integer> h=new HashMap<>();
        for(char x:c){
            int i=h.getOrDefault(x,0)+1;
            h.put(x,i);
        }
        System.out.println(h);
    }
}