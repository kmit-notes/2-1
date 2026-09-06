// ---------------- Product Class ----------------
class Product {
    String name;
    double price;
    boolean onSale;

    public Product(String name, double price, boolean onSale) {
        this.name = name;
        this.price = price;
        this.onSale = onSale;
    }
}

// ---------------- Base Store Class ----------------
class Store {
    String storeName;

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public void displayMessage(String msg) {
        System.out.println("[" + storeName + "] " + msg);
    }
}

// ---------------- Cart Class ----------------
class Cart extends Store {
    Product[] products;
    int productCount;   // number of products currently in cart
    static final int MAX_PRODUCTS = 10;

    public Cart(String storeName) {
        super(storeName);
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
    }

    public void addProduct(Product p) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount] = p;
            productCount++;
            displayMessage(p.name + " added to cart, price: " + p.price + (p.onSale ? " (on sale)" : ""));
        } else {
            displayMessage("Cart full! Cannot add " + p.name);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].price;
        }
        if (total > 3000) {
            total *= 0.8; // 20% discount
        }
        return total;
    }
}

// ---------------- Customer Class ----------------
class Customer extends Store {
    String customerName;
    Cart cart;

    public Customer(String storeName, String customerName) {
        super(storeName);
        this.customerName = customerName;
        cart = new Cart(storeName);
    }

    public void addToCart(Product p) {
        cart.addProduct(p);
    }

    public void checkout() {
        double total = cart.calculateTotal();
        displayMessage(customerName + "'s total cart value: " + total);
    }
}

// ---------------- Main Class ----------------
public class StoreSimulation {
    public static void main(String[] args) {
        // Products
        Product p1 = new Product("Laptop", 1500, false);
        Product p2 = new Product("Headphones", 800, true);
        Product p3 = new Product("Shoes", 1200, false);

        // Customer
        Customer customer = new Customer("TechStore", "Ram");

        // Adding products to cart
        customer.addToCart(p1);
        customer.addToCart(p2);
        customer.addToCart(p3);

        // Checkout
        customer.checkout();
    }
}