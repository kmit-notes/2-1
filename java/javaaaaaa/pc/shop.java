class shop{
    public static void main(String[] args){
        Customer c=new Customer();
        Product p=new Product(null,0);
        Product p1=new Product(null,0);
        Product p2=new Product(null,0);
        c.addToCart(p);
        c.addToCart(p);
        c.addToCart(p);
        c.addToCart(p2);
        Product f []=c.cart;
        float total=0.0f;
        for (Product product : f){
            total+=product.getPrice();
        }

    }
}