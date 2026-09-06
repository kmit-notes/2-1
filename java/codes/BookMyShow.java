/* Develop a BookMyShow application where you have different events like movies,comedy,tours,workshop,etc. A user can
book tickets for that event,every event would have a venue and limited number of tickets.
An event would have a date,slot,rating,tickets.etc.
Rama books 2 movie tickets, Shanta wants to book for the same movie but it shows her all tickets are sold out.
Priya is browsing through the events based on this weeks upcoming events, find a comedy show for which she wants 
to book 10 tickets, but she is getting all tickets seperately, not together. 
Admin needs to know this weeks  */

import java.time.LocalDate;
class user{
   int userID;
   String name;
}
class event{
   LocalDate date=LocalDate.now();
   int slot;
   float rating;
   String venue;
}
class ticket{
}
class movies extends event{
   super.venue="Theatre";
   int no_of_tickets=50;
   
}
class comedy extends event{

}
class tours extends event{

}
class workshop extends event{

}


class BookMyShow{
   public static void main(String[] args){

   }
}