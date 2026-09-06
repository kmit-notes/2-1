public /*develop a bookmyshow application where you have different events like movies,comedy,tours, workshop etc.A customers can book the tickets for that event ,every event would have a venue and limited number of tickets.An event wouldd have a venue and limited number of tickets.
A customers can rate the event too.While booking the ticket calculate the total cost and give it to the customers.
An event would have a date,slot,rating,tickets etc 
Rama books 2 tickets ,Shanta wants to book for the same movie but it shows her all tickets are sold out.
Priya is browsing through the events based on this weeks upcoming events ,finds a comedy show for which she wants to book 10 tickets ,but she is getting all tickets separately , not together.
Admin needs to know this weeks sale.
A customer needs a list how many tickets did he buy.
*/

// class allMovies{
//   String[] moviesnames  = new String[4];
//   moviesnames[0] = "OG";
//   moviesnames[1] = "35";
//   moviesnames[2] = "oye";
//   moviesnames[3] = "sye";
//   // select a category- movie ;
//   // i will display all movies list

// }
import java.util.Scanner;
import java.util.Arrays;
class q{
  public static void main(String[] args){
    movies m1 =  new movies();
    comedy co1 = new comedy();
    tours t1 =  new tours();
    workshop w1 = new workshop();
    admin a1 = new admin();
    customers c1 = new customers("Unnathi","movies");
    c1.knowNoOfSeats(c1,m1,co1,t1,w1,a1);
    customers c2 = new customers("Shreya","movies");
    c2.knowNoOfSeats(c2,m1,co1,t1,w1,a1);
    customers c3 = new customers("Ram","comedy");
    c3.knowNoOfSeats(c3,m1,co1,t1,w1,a1);
    customers c6 = new customers("Rajesh","comedy");
    c6.knowNoOfSeats(c6,m1,co1,t1,w1,a1);
    customers c4 = new customers("Raju","tours");
    c4.knowNoOfSeats(c4,m1,co1,t1,w1,a1);
    customers c5 = new customers("anitha","tours");
    c5.knowNoOfSeats(c5,m1,co1,t1,w1,a1);
    customers c7 = new customers("ravi","workshop");
    c7.knowNoOfSeats(c7,m1,co1,t1,w1,a1);
    // System.out.println("How many seats do you want to book?");
    // int noOfSeats = sc.nextInt();
    // c1.BookTicket(noOfSeats,m1);
  }
}
abstract class users{}
class admin extends users{
  static float TotalMoney;
  static int mseatssold;
  static int cseatssold;
  static int tseatssold;
  static int wseatssold;
  void Incrementing(float bill,int noOfSeats,String category){
    if(category.equals("movies")){
      mseatssold += noOfSeats;
    }
    else if(category.equals("comedy")){
      cseatssold += noOfSeats;
      // System.out.println(cseatssold);
      // System.out.println(TotalMoney);
    }
    else if(category.equals("tours")){
      tseatssold +=noOfSeats;
    }
    else if(category.equals("workshop")){
      wseatssold +=noOfSeats;
    }
    TotalMoney += bill;
    // System.out.println(mseatssold+cseatssold+tseatssold);//prints sum of all tickets sold like no of tickets sold
    // System.out.println(TotalMoney);// Total money earned by admin.
  }
}
class customers extends users{
    String name;
    String category;
    Scanner sc = new Scanner(System.in);
    customers(String name,String category){
      this.name = name;
      this.category = category;
    }
    void BookTicket(int noOfSeats,movies m1,comedy co1,tours t1, workshop w1,admin a1){
        if(category.equals("movies")){
           m1.TicketBooking(noOfSeats,m1,a1);
        }
        else if(category.equals("comedy")){
          co1.TicketBooking(noOfSeats,co1,a1);
        }
        else if(category.equals("tours")){
          t1.TicketBooking(noOfSeats,t1,a1);
        }
        else if(category.equals("workshop")){
          w1.TicketBooking(noOfSeats,w1,a1);
        }
        else{System.out.println("Invalid category");}
    }
    void knowNoOfSeats(customers c1,movies m1,comedy co1, tours t1, workshop w1,admin a1){
      System.out.println("How many seats do you want to book "+this.name+"?"+"("+this.category+")");
      int noOfSeats = sc.nextInt();
      c1.BookTicket(noOfSeats,m1,co1,t1,w1,a1);
    }
}
class ticket{}
class event{
  String name;
  String date;
  int ticketsCount;
  float price;
  float bill;
  Scanner sc1 = new Scanner(System.in);
}
class movies extends event{
  boolean[][] mseats;
  String[][] dupmseats;
  movies(){
    super.name = "OG";
    super.date = "15-10-2025";
    super.ticketsCount = 100; // in java in boolean arrays values in default are already false.
    super.price = 250;
    dupmseats = new String[10][10];
    for(int i =0;i<10;i++){
      for(int j=0;j<10;j++){
        dupmseats[i][j] = i+""+j;
      }
    }
    mseats = new boolean[10][10];
  }
  void TicketBooking(int noOfSeats,movies m1,admin a1){
        for(int i =0;i<10;i++){
          for(int j =0;j<10;j++){
            System.out.print(dupmseats[i][j]+" ");
        }System.out.println();
        }
        System.out.println("Enter your seat numbers"+"("+noOfSeats+")");
        int[] ticketNumbers = new int[noOfSeats];
        for(int i =0;i<noOfSeats;i++){
            System.out.print("Seat "+(i+1)+":");
            int x = sc1.nextInt();
            //constraint 2 : duplicate ticket numbers cannot be entered in at once.- NOT FULLY SOLVED
            for(int j:ticketNumbers){
              if(j==x){
                System.out.println("Duplicate entered");
               return;
              }
            }
            ticketNumbers[i] = x;
        }
        // constraint 1 : dupseats and mseats should become na and true respectiveky when booked
        for(int i:ticketNumbers){
          dupmseats[i/10][i%10] = "NA";
          mseats[i/10][i%10] = true;
        }
        super.bill = noOfSeats*price;
        System.out.println("Bill : "+super.bill);
        System.out.println("Tickets booked!");
        a1.Incrementing(super.bill,noOfSeats,"movies");
        // System.out.println(Arrays.toString(ticketNumbers));
        // for(int i =0;i<10;i++){
        //   for(int j =0;j<10;j++){
        //     System.out.print(dupmseats[i][j]+" ");
        // }System.out.println();
        // }
    }
}
class comedy extends event{
    boolean[][] cseats;
    String[][] dupcseats; 
    comedy(){
      super.name = "Comedy tour";
      super.date = "16-10-2025";
      super.ticketsCount = 80;
      super.price = 400;
      dupcseats = new String[10][8];
      for(int i =0;i<10;i++){
        for(int j=0;j<8;j++){
          dupcseats[i][j] = String.format("%02d", i*8 + j);
        }
    }
      cseats = new boolean[10][8];
    }
    void TicketBooking(int noOfSeats, comedy co1,admin a1){
      for(int i =0;i<10;i++){
          for(int j =0;j<8;j++){
            System.out.print(dupcseats[i][j]+" ");
        }System.out.println();
        }
      
      System.out.println("Enter your seat numbers"+"("+noOfSeats+")");
        int[] ticketNumbers = new int[noOfSeats];
        for(int i =0;i<noOfSeats;i++){
            System.out.print("Seat "+i+":");
            int x = sc1.nextInt();
            //constraint 2 : duplicate ticket numbers cannot be entered in at once.- NOT FULLY SOLVED
            for(int j:ticketNumbers){
              if(j==x){
                System.out.println("Duplicate entered");
               return;
              }
            }
            ticketNumbers[i] = x;
        }
        // constraint 1 : dupseats and mseats should become na and true respectiveky when booked
        for(int i:ticketNumbers){
          dupcseats[i/8][i%8] = "NA";
          cseats[i/8][i%8] = true;
        }
        super.bill = noOfSeats*price;
        System.out.println("Bill : "+super.bill);
        System.out.println("Tickets booked!");
        a1.Incrementing(super.bill,noOfSeats,"comedy");
        // System.out.println(Arrays.toString(ticketNumbers));
        // for(int i =0;i<10;i++){
        //   for(int j =0;j<10;j++){
        //     System.out.print(dupmseats[i][j]+" ");
        // }System.out.println();
        // }
    }
}
class tours extends event{
    boolean[] tseats;
    String[] duptseats;
    static int bookedTickets = 0;
    static int availableTickets = 300;
    tours(){
      super.name = "Music tour";
      super.date = "17-10-2025";
      super.ticketsCount = 300;
      super.price = 1000;
      tseats = new boolean[ticketsCount];// already everything inside is initialised with false.
      /*
      duptseats = new String[ticketsCount];
      for(int i = 0;i<ticketsCount;i++){
          duptseats[i] = Integer.toString(i); 
      }
      */
    }
    void TicketBooking(int noOfSeats,tours t1,admin a1){
      if(availableTickets-noOfSeats<0){
        System.out.println("Sorry, only " + availableTickets + " tickets are available!");
        return;
      }else{
        availableTickets = availableTickets - noOfSeats;
        bookedTickets = noOfSeats+bookedTickets;
        System.out.println("You have booked "+noOfSeats+" tickets from this tour");
        // System.out.println(availableTickets);
        // System.out.println(bookedTickets);
        super.bill = noOfSeats*price;
        System.out.println("Bill : "+super.bill);
        System.out.println("Tickets booked!");
        a1.Incrementing(super.bill,noOfSeats,"tours");
      }
    }
    /*
    void TicketBooking(int noOfSeats,tours t1){
      System.out.println("Enter your seat numbers"+"("+noOfSeats+")"+"from (1-300)");
      int[] ticketNumbers = new int[noOfSeats];
      for(int i=0;i<noOfSeats;i++){
        System.out.print("Seat "+(i+1)+":");
        int x = sc1.nextInt();
        for(int y: ticketNumbers){
          if(y==x){
            System.out.println("Duplicate entered,Try booking again");
            return;
          }
        }
        ticketNumbers[i] = x;
      }
        // for(int i =0;i<noOfSeats;i++){
        //   System.out.print(ticketNumbers[i]+" ");
        // }
      for(int i:ticketNumbers){
          duptseats[i-1] = "NA";
          tseats[i-1] = true;
      }
      // for(int i = 0;i<ticketsCount;i++){
      //   System.out.print(duptseats[i] +" ");
      // }
      // for(int i =0;i<ticketsCount;i++){
      //   System.out.print(tseats[i]+" ");
      // }
    }
    */
}
class workshop extends event{
    boolean[][] wseats; 
    String[][] dupwseats;
    workshop(){
      super.name = "EWS";
      super.date = "18-10-2025";
      super.ticketsCount = 50;
      super.price = 600;
      dupwseats = new String[10][5];
      for(int i =0;i<10;i++){
      for(int j=0;j<5;j++){
        dupwseats[i][j] = String.format("%02d", i*5 + j);
      }
    }
      wseats = new boolean[10][5];
    }
    void TicketBooking(int noOfSeats,workshop m1,admin a1){
        for(int i =0;i<10;i++){
          for(int j =0;j<5;j++){
            System.out.print(dupwseats[i][j]+" ");
        }System.out.println();
        }
        System.out.println("Enter your seat numbers"+"("+noOfSeats+")");
        int[] ticketNumbers = new int[noOfSeats];
        for(int i =0;i<noOfSeats;i++){
            System.out.print("Seat "+(i+1)+":");
            int x = sc1.nextInt();
            //constraint 2 : duplicate ticket numbers cannot be entered in at once.- NOT FULLY SOLVED
            for(int j:ticketNumbers){
              if(j==x){
                System.out.println("Duplicate entered");
               return;
              }
            }
            ticketNumbers[i] = x;
        }
        // constraint 1 : dupseats and mseats should become na and true respectiveky when booked
        for(int i:ticketNumbers){
          dupwseats[i/5][i%5] = "NA";
          wseats[i/5][i%5] = true;
        }
        super.bill = noOfSeats*price;
        System.out.println("Bill : "+super.bill);
        System.out.println("Tickets booked!");
        a1.Incrementing(super.bill,noOfSeats,"workshop");
        // System.out.println(Arrays.toString(ticketNumbers));
        // for(int i =0;i<10;i++){
        //   for(int j =0;j<10;j++){
        //     System.out.print(dupmseats[i][j]+" ");
        // }System.out.println();
        // }
    }
}




// class customers{}
// class event{}
// class ticket{}
// class movies{}
// class comedy{}
// class tours{}
// class workshop{}

    // for(int i = 0;i<10;i++){
    //   for(int j = 0;j<10;j++){
    //     mseats[i][j] = false;
    //   }
    // }

// we can pass objects to a function to access them inside example m1



// boolean allBooked = true;  // assume sold out
// for (int i = 0; i < 10; i++) {
//     for (int j = 0; j < 10; j++) {
//         if (!ticketsArr[i][j]) { // if any seat is free
//             allBooked = false;
//             break;
//         }
//     }
//     if (!allBooked) break; // no need to check further
// }

// if (allBooked) {
//     System.out.println("House full");
//     return;
// } {
    
}
