import java.util.List;
import java.util.ArrayList;

public class testCollections {
    public static void main(String[] args) {
        List l= new ArrayList();
        l.add(10);
        l.add(20);
        l.add(30);
        System.out.println(l);

        List l2=new ArrayList();
        l2.add(50);
        l2.add(60);
        l2.add(70);
        System.out.println(l2);

        List l3=new ArrayList();
        l3=l+l2;
        System.out.println(l3);
    }
}


// create a list with 10,20,30,40
/*Create another list with 20,30,40,50
 * merge them
 * demerge them
 * get me the index of 10 in l after demerging
 * get me the index of 40 in l2
 * check if 100 is there inl
 * check if 20 is there in l2
 * remove 10 from l
 * remove 30 from l and l2
 */