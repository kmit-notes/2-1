class customer{
    String name,age,address;
    Product [] cart;
    int c=0;
    Customer(){
        cart = new Product[10];
    }
    void addToCart(Product p){
        cart[c]=p;
        c++;
    }
}