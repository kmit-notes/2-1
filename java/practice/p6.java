/*
Sort a list of strings by length.
If two strings have the same length, sort them alphabetically.

*/
import java.util.*;
public class p6{
    public static void main (String[] args) {
        ArrayList<String> strs = new ArrayList<>();
        strs.addAll(List.of("adf","kjg","qwewr","poi"));
        Collections.sort(strs,new LengthComparator());
        System.out.println(strs);
        
    }
}
class LengthComparator implements Comparator{
    public int compare(Object o1, Object o2){
        String s1 = (String) o1;
        String s2 = (String) o2;
        if(s1.length()==s2.length())
            return s1.compareTo(s2);
        return s1.length()-s2.length();
    }
}