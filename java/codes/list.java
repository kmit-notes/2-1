import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class list {
    public static void main(String[] args) {
      List l1=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,2));
      List l2=new ArrayList<>(Arrays.asList(2));

      l1.removeAll(l2);

      System.out.println("l1: "+l1);

    }
}
