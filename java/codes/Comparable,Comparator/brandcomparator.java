import java.util.*;

public class brandcomparator implements Comparator{
    @Override
    public int compare(Object o1,Object o2){
    Product p1= (Product)o1;
    Product p2= (Product)o2;
    return (int)(p1.brand.compareTo(p2.brand));
}
    
}