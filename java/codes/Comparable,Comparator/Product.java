import java.util.*;
public class Product implements Comparable {
    //comparable interface would instruct the jvm how to sort a user defintd object
    //only product obj in this***
    /*
    when a single entity needs to be sorted on various parameters
    brand rating etc..
    we make use of comparators this is also interface 
    default sorting only on way this is comparable
    multi sorting is comparator
    
    */
    int sku;
    double price;
    String brand;
    boolean isAvailable;
    double rating;
    Product(int sku,double price,String brand,boolean isAvailable,double rating)
    {
        this.sku = sku;
        this.brand = brand;
        this.price = price ;
        this.isAvailable = isAvailable;
        this.rating = rating;
    }
    public String toString()
    {
        return brand +" "+price+" "+rating;
    }
    @Override
    public int compareTo(Object o){
        Product l=(Product)o;
        return (int)(this.sku-l.sku);
    }
    
    public static void main (String[] args) {
        //collections.sort(List*(only*)) is a static method 
        Product p1=new Product(101,566.00,"SkyBag",true,3.5);
        Product p2=new Product(102,5166.00,"Wildcraft",true,2.5);
        Product p3=new Product(103,2566.00,"Safari",true,4.5);
        Product p4=new Product(104,5656.00,"Tatal",true,5);
        
        List<Product> l1=new ArrayList<>();
        l1.add(p1);
        l1.add(p2);
        l1.add(p3);
        l1.add(p4);
        Collections.sort(l1);//default looking for comparable
        System.out.println("default"+l1);
        //other is send a list and send the object of comparable
        Collections.sort(l1,new pricecomparator());
        System.out.println("price"+l1);
        //sort and filter 
        Collections.sort(l1,new brandcomparator());
        System.out.println("brand"+l1);
        
    }
}
