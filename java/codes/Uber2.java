/*
Design and implement a ride-hailing simulation named Mini-Uber (RideNow) using Object-Oriented Programming concepts.

Features:
i)Rider requests a ride.
ii)Nearest available driver is assigned.
iii)Trip fare depends on distance and vehicle type.
iv)Rider can rate driver at end of trip.

Entities:
User: id, name, phone
Driver: id, name, vehicleType, isAvailable, rating
Ride: id, rider, driver, startLocation, endLocation, distanceKm, fare, status (REQUESTED/ONGOING/COMPLETED)

Rules / Constraints:
i).A driver can handle only one ongoing ride.
ii).Fare calculation:

 a) Base fare ₹50
 b) ₹10/km for Sedan, ₹8/km for Hatchback, ₹15/km for SUV
iii).After ride, status changes to COMPLETED and driver becomes available again.

Test Scenarios:
1. User requests a ride → nearest available driver assigned.
2. Mark ride as completed → fare computed, driver rating updated.
3. Request new ride → previously occupied driver not reassigned until available.
4. Print driver leaderboard (by rating).




*/
import java.util.Scanner;
class User{
    int id;
    String name;
    int phone;
    static int i=0;
    User(int id,String name,int phone){
        this.id=id;
        this.name=name;
        this.phone=phone;
    }
    User(){
        name="Manasa";
        phone=98;
    }
    void requestsRide(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Specify the start location: ");
        String start=sc.nextLine();
        System.out.print("Specify the end location: ");
        String end=sc.nextLine();
        System.out.print("Specify the distance in kms: ");
        double kms=sc.nextDouble();
        Ride r=new Ride(i,name,start,end,kms);
    }
    
    void showDetails(){
        System.out.println("User Details: ");
        System.out.println("User Id: "+id);
        System.out.println("User Name: "+name);
        System.out.println("User Contact: "+phone);
        // super.showDetails();
    }
}

class Driver{
    int id;
    String name;
    String vehicleType;
    Boolean isAvailable=true;
    double rating;
    static Driver d[]=new Driver[10];
    static int counter=0;
    // Driver current=new Driver();
    Driver(int id,String name,String vehicle){
        d[counter]=this;
        counter++;
        this.id=id;
        this.name=name;
        vehicleType=vehicle;
    }
    
    // Driver(){
    //     d[counter]=this;
    //     counter++;
    // }
    int current;
    Driver driverAssigned(){
        for (int i=0;i<d.length;i++){
            if (d[i].isAvailable){
                System.out.println("The driver is available,booking your ride.");
                d[i].isAvailable=false;
                current=i;
                return d[i];
            }
        }
        System.out.println("The drivers are not available.");
        Driver d=new Driver(id, name, vehicleType);
        return d;
    }
    // void endRide(){
    //     isAvailable=true;
        
    // }
    void showDetails(){
        for (int i=0;i<d.length;i++){
            if (current==i){
                System.out.println("Driver Details: ");
                System.out.println("Driver id: "+d[i].id);
                System.out.println("Driver Name: "+d[i].name);
                System.out.println("Vehicle Type: "+d[i].vehicleType);
                System.out.println("Rating is: "+d[i].rating);
            }
        }
        
    }
    
    
    
}

class Ride{
    int id;
    String rider;
    String driver;
    String startLocation;
    String endLocation;
    double distanceKm;
    double fare;
    String status;
    
    Ride(int id,String rider,String start,String end,double kms){
        this.id=id;
        this.rider=rider;
        startLocation=start;
        endLocation=end;
        distanceKm=kms;
    }
   
    void requestingRide(String name,String start,String end,double kms){
        rider=name;
        startLocation=start;
        endLocation=end;
        distanceKm=kms;
        System.out.println("The ride is requested.");
        status="requested";
        System.out.println("Status: "+status);
        super.driverAssigned();
    }
    
    double totalFare(){
        this.fare=50;
        if (d[current].vehicleType=="sedan"){
            this.fare+=(distanceKm*10);
        }
        else if (d[current].vehicleType=="hatchback"){
            this.fare+=(distanceKm*8);
        }
        else if(d[current].vehicleType=="suv"){
            this.fare+=(distanceKm*15);
        }
        else{
            status="completed";
            // System.out.println("The ride is completed.");
            return fare;
        }
        status="completed";
        d[current].isAvailable=true;
        // System.out.println("The ride is completed.");
        return fare;
        
    }
    void rating(){
        System.out.print("Rate the driver out of 10: ");
        Scanner sc=new Scanner(System.in);
        double rating=sc.nextDouble();
        d[current].rating=rating;
        System.out.println("Thank you for your feedback.");
    }
    void showDetails(){
        this.id=(int)(Math.random()*100);
        System.out.println("\nRide Details: ");
        System.out.println("Ride id: "+this.id);
        System.out.println("Start Location: "+startLocation);
        System.out.println("End Location: "+endLocation);
        System.out.println("The fare is: "+totalFare());
        System.out.println();
        System.out.println("The ride is completed.");
        System.out.println();
        rating();
        System.out.println();
        super.showDetails();
        
    }
    
}


class test{
    public static void main(String[] args){
        // the drivers should already be present so as to access them and use it so let us take a driver obj
        Driver d=new Driver();
        d.id=1;
        d.name="Shyam";
        d.vehicleType="sedan";
        // d.showDetails();
        
        User u=new User(12,"Manasa",93936923);
        u.requestsRide();
        // u.requestsRide();
        u.showDetails();
        
    }
}


public class Uber2 {
    
}
