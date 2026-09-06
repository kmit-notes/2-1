import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class mapTest {
    public static void main(String[] args) {
        Map<Integer,Double> marksheet=new HashMap<>();
        marksheet.put(101,6.7);
        marksheet.put(102,7.24);
        marksheet.put(103,8.56);
        marksheet.put(104,7.89);
        marksheet.put(105,8.7);
        marksheet.put(106,5.34);
        marksheet.put(107,6.23);
        marksheet.put(108,7.5);
        marksheet.put(100,8.9);

        System.out.println(marksheet);

        // remove entry with key 104
        marksheet.remove(104);
        System.out.println("1: "+marksheet);

        // update the value to 9.0 for key 101
        marksheet.replace(101, 9.0);
        System.out.println("2: "+marksheet);

        // Update the key to 200 for a value 8.7
        marksheet.remove(105);
        marksheet.put(200,8.7);
        System.out.println("3: "+marksheet);


        // Add two more entries 201:9.8  202  8.7

        marksheet.put(201, 9.8);
        marksheet.put(202, 8.7);
        System.out.println("4: "+marksheet);


        //Add an entry null : 6.6

        marksheet.put(null, 6.6);
        System.out.println("5: "+marksheet);


        //Add one more entry null : 10.0

        marksheet.put(null, 10.0);
        System.out.println("6: "+marksheet);

        // print all the roll nos having cgpa >7.0

        // marksheet.remove(null);

        Set s=marksheet.keySet();
        Iterator i=s.iterator();
        System.out.println("Roll No's having cgpa > 7.0");
        // while(i.hasNext()){
        //     if (marksheet.get(i.next())>9.0){
        //         System.out.println(i.next());
        //     }
        // }
        // for ()

        // print roll no and cgpa for rollnos in 200 series
        // Give the average cgpa of the total class
        // which rollno stood first in d class
        // which rollno stood last in class





    }
    
}
