/*
A customer walks in a store and adds 3 products in the cart. 
the cart value if it exceeds 3000 there is 20% discount on the
 total value. the product can also be in sale.


*/

class Product{
    final String name;
    final float price;
    Product(String name,float price){
        this.name = name;
        this.price = price;
    }
}
class Customer{
    Product [] cart;
    double bill =0;
    int c = 0;
    Customer(){
        cart = new Product[10];
    }
    void addToCart(Product p){
        cart[c] = p;
        c++;
        bill+=p.price;
        if(bill>3000){
        double b = bill*0.8;
            System.out.println("HURRAY! Discount Applied Your Bill: ₹"+b);
        }
        else{
            System.out.println("Your Bill: ₹"+bill);
        }
    }

}
class Cart{
    public static void main(String[] args){
    Customer c1 = new Customer();
    Product p1 = new Product("Toy1",2000);
    Product p2 = new Product("Toy2",2000);
    Product p3 = new Product("Toy3",2000);
    
    c1.addToCart(p1);
    c1.addToCart(p2);
    c1.addToCart(p3);
    
    }
}
