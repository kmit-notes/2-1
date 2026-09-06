/*
Given a list: ["apple", "ant", "ball", "bat", "cat"]
Group words by their first letter using a Map.
Expected:
a -> [apple, ant]
b -> [ball, bat]
c -> [cat]

*/
import java.util.*;
public class p8{
    public static void main (String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.addAll(List.of("apple", "ant", "ball", "bat"));
        HashMap<Character, ArrayList<String>> ans = new HashMap<>();
        for(String s: arr){
            Character c = s.charAt(0);
            System.out.println(c);
            if(ans.keySet().contains(c)){
                System.out.println(ans.get(c));
                // ans.put(c,ans.get(c).add(s));
            }
            else{
                ans.put(c,new ArrayList<>());
                // ans.put(c,ans.get(c).add(s));
            }
        }
    }
}