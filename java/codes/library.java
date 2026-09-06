/*
Students can borrow/deposit books in the library, 
they can have only 3 books with them. Every book has a card in it 
which checks who all had borrowed the book.
If the user does not return the book within 5 days for every day 
50 rupees fine is there.


*/
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
class Book{
    final String bname;
    final int price;
    boolean issue = false;
    LocalDate issueDate;
    Customer [] card;
    Book(String name,int p){
        bname =name;
        price = p;
        card =new Customer[10];
    }
}
class Customer{
    final String cname;
    int age;
    Book [] books;
    int bcount = 0;
    Customer(String name,int a){
        cname =name;
        age =a;
       books = new Book[3];
    }
    boolean borrow(Book b){
        if(b.issue){
            System.out.println("This Book is already Issued");
            return false;
        }
        else{
        b.issue = true;
        if(bcount<3){
            b.issueDate = LocalDate.now();
            books[bcount] = b;
            b.card[bcount] = this; ///*////
            bcount++;
            System.out.println("Book Succesfully added to Cart");
        }
        else{
            System.out.println("Borrowing of more than 3 Books not allowed");
        }
    }
    return true;
    }
    
    void deposit(Book b,String r_date){
        b.issue = false;
        LocalDate returnDate = LocalDate.parse(r_date);
        long days = ChronoUnit.DAYS.between(b.issueDate,returnDate);
        //can also use ChronoUnit.YEARS.between(i,rd) if u wany years ***
        if(days>5){
            long fdays = days-5;
            float fine = b.price + fdays*50;
            System.out.println("Book Returned Late Fine: ₹"+(fdays*50));
            System.out.println("Your Total Amoount With Fine: ₹"+fine);
        }
        else{
            System.out.println("Book Returned In Time");
            System.out.println("Bill: ₹"+b.price);
        }
    }
}

class Lib{
    public static void main(String[] args){
        Customer c1 = new Customer("Alice",19);
        Book b1 = new Book("Book1",499);
        Book b2 = new Book("Book2",899);
        Book b3 =new Book("Book3",299);
        Book b4 = new Book("Book4",799);
        
        c1.borrow(b1);
        c1.borrow(b2);
        c1.borrow(b3);
        c1.borrow(b4);
        System.out.println();
        c1.borrow(b1);
        
        c1.deposit(b1,"2025-10-15");
    }
}
