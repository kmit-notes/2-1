import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class date {
    LocalDate addDate(LocalDate date,int d){
        return date.plusDays(d);
    }
    LocalDate addmonths(LocalDate date,int months){
        return date.plusMonths(months);
    }
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        System.out.println("Today's date is: "+date);
        LocalTime time=LocalTime.now();
        LocalDateTime dt=LocalDateTime.now();
        System.out.println("Time is: "+time);
        System.out.println("Date and time is: "+dt);
        System.out.println("");
        System.out.println("Year: "+date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfYear());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        DateTimeFormatter form=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date_time=dt.format(form);
        System.out.println("New format: "+date_time);
        date d=new date();
        System.out.println(d.addmonths(date, 3));
    
    }
    
}
