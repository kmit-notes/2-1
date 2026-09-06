// create a list with 10,20,30,40
/*Create another list with 20,30,40,50
 * merge them
 * demerge them  // not possible if they contain same elements
 * get me the index of 10 in l after demerging
 * get me the index of 40 in l2
 * check if 100 is there inl
 * check if 20 is there in l2
 * remove 10 from l
 * remove 30 from l and l2
 */
import java.util.List;
import java.util.ArrayList;
public class collections {
    public static void main(String[] args) {
        List l1=new ArrayList();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);

        List l2=new ArrayList();
        l2.add(20);
        l2.add(30);
        l2.add(40);
        l2.add(50);

        System.out.println("l1: "+l1);
        System.out.println("l2: "+l2);
        System.out.println("");

        l1.addAll(l2);

        System.out.println("l1: "+l1);
        System.out.println("l2: "+l2);
        System.out.println("");

        // l1.removeAll(l2);   // also removes the l1 elemnets which are in l2
        
        // l1.retainAll(l2);  // retains all the elements of l2 and removes remaining elements
        
        // System.out.println("l1: "+l1);
        // System.out.println("l2: "+l2);
        // System.out.println("");

        System.out.println("Index of 10 in l1: "+l1.indexOf(10));
        System.out.println("Index of 40 in l2: "+l2.indexOf(40));

        System.out.println("100 in l1? "+l1.contains(100));
        System.out.println("20 in l1? "+l2.contains(20));

        l1.remove((Object)10);

        System.out.println("l1: "+l1);

        l1.remove((Object)30);
        System.out.println("l1: "+l1);  // only the first occurnce is removed

        for (int i=0;i<l1.size();i++){
            Object k=l1.get(i);
            Integer x=(Integer)k; // downreferencing
            l1.set(i, x+5); //updating the existing elements
        }
        System.out.println("\nl1: "+l1);
    }
    
}


// wrapper classes 
/*
 * each datatype has a corresponding wrapper class to it
 */