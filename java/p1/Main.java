import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Welcome to the Travel Platform Booking Intelligence System.");
        FileReader f=new FileReader("travel_booking.csv");
        BufferedReader bf = new BufferedReader(f);
        String line;
        line = bf.readLine();
        ArrayList<Booking> bl = new ArrayList<Booking>();

        HashSet<Booking> hs = new HashSet<Booking>();

        while ((line = bf.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println(data[7]);
            String feedback = data[7];
            String classification;
            if (feedback.toLowerCase().contains("complaints") || feedback.toLowerCase().contains("rude")
                    || feedback.toLowerCase().contains("unprofessional") || feedback.toLowerCase().contains("poor")) {
                classification = "ESCALATED";
            } else if (feedback.toLowerCase().contains("slow response")
                    || feedback.toLowerCase().contains("needs improvement")
                    || feedback.toLowerCase().contains("inconsistent")) {
                classification = "ATTENTION_REQUIRED";
            } else if (feedback.toLowerCase().contains("good") || feedback.toLowerCase().contains("reliable")
                    || feedback.toLowerCase().contains("smooth") || feedback.toLowerCase().contains("well organised")) {
                classification = "SATISFACTORY";
            } else {
                classification = "ELITE";
            }
            // bookingId,customerName,destination,packageCategory,transportType,travelCost,season,feedback
            String customerName = data[1];
            int bookingId = Integer.parseInt(data[0]);
            String destination = data[2];
            String packageCategory = data[3];
            String transportType = data[4];
            double travelCost = Double.parseDouble(data[5]);
            String season = data[6];
            String category = classification;
            Booking b = new Booking(bookingId, customerName, destination, packageCategory, transportType, travelCost,
                    season, feedback, category);
            bl.add(b);
            hs.add(b);
        }

        bf.close();

        // for(Booking bi : bl){
        // System.out.println(bi);
        // }

        // for(Booking bi : hs){
        // System.out.println(bi);
        // }

        System.out.println(bl.size());
        System.out.println(hs.size());

        Collections.sort(bl, new Comparator<Booking>() {
            public int compare(Booking a, Booking b) {
                if (a.category != b.category) {
                    int ao = 0;
                    if(a.category.equals("ESCALATED")){
                        ao = 4;
                    }else if(a.category.equals("ATTENTION_REQUIRED")){
                        ao = 3;
                    }else if(a.category.equals("SATISFACTORY")){
                        ao = 2;
                    }else if(a.category.equals("ELITE")){
                        ao = 1;
                    }
                    int bo = 0;
                    if(b.category.equals("ESCALATED")){
                        bo = 4;
                    }else if(b.category.equals("ATTENTION_REQUIRED")){
                        bo = 3;
                    }else if(b.category.equals("SATISFACTORY")){
                        bo = 2;
                    }else if(b.category.equals("ELITE")){
                        bo = 1;
                    }
                    return bo-ao;
                } else {
                    if (a.travelCost > b.travelCost) {
                        return -1;
                    } else if (a.travelCost < b.travelCost) {
                        return 1;
                    }
                    return 0;

                }

            }
        });

        for (Booking bi : bl) {
            System.out.println(bi.customerName +  "|" +  bi.destination +  "|"  + bi.category + "|" +  bi.travelCost + "|" + bi.feedback);
        }

        Collections.sort(bl, new Comparator<Booking>() {
            public int compare(Booking a, Booking b) {
                // if (b.travelCost != a.travelCost) {
                // return b.travelCost - a.travelCost;
                // } else {
                // return b.travelCost - a.travelCost;
                // }

                if (a.travelCost > b.travelCost) {
                    return -1;
                } else if (a.travelCost < b.travelCost) {
                    return 1;
                }
                return 0;
            }
        });

        for (Booking bi : bl) {
            System.out.println(bi.customerName +  "|" +  bi.destination +  "|"  + bi.category + "|" +  bi.travelCost + "|" + bi.feedback);
        }

        Collections.sort(bl, new Comparator<Booking>() {
            public int compare(Booking a, Booking b) {
                if (a.travelCost > b.travelCost) {
                    return -1;
                } else if (a.travelCost < b.travelCost) {
                    return 1;
                }
                return 0;
            }
        });





        Collections.sort(bl, new Comparator<Booking>() {
            public int compare(Booking a, Booking b) {
                if (a.season != b.season) {
                    if(a.season.equals("Peak")){
                        return -1;
                    }
                }
                return 0;
            }
        });


        for (Booking bi : bl) {
            System.out.println(bi.customerName +  "|" +  bi.destination +  "|"  + bi.category + "|" +  bi.travelCost + "|" + bi.feedback + "|" + bi.season);
        }


        Scanner sc = new Scanner(System.in);

        String i = sc.nextLine();
        for(Booking bi : bl){
            if(bi.destination.equals(i)){
                System.out.println(bi.customerName +  "|" +  bi.destination +  "|"  + bi.category + "|" +  bi.travelCost + "|" + bi.feedback + "|" + bi.season);
            }
        }

        String j = sc.nextLine();
        for(Booking bi : bl){
            if(bi.packageCategory.equals("International") &&  bi.travelCost > Float.parseFloat(j)){
                System.out.println(bi.customerName +  "|" +  bi.destination +  "|"  + bi.category + "|" +  bi.travelCost + "|" + bi.feedback + "|" + bi.season);
            }
        }

        for(Booking bi : bl){
            if(bi.transportType.equals("Flight") &&  bi.category.equals("ESCALATED")){
                System.out.println(bi.customerName +  "|" +  bi.destination +  "|"  + bi.category + "|" +  bi.travelCost + "|" + bi.feedback + "|" + bi.season);
            }
        }


        float total = 0;
        for(Booking bi : bl){
            total += bi.travelCost;
        }

        System.out.println("The total cost is: " + total);

        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
        for(Booking bi : bl){
            int c1 = hm1.getOrDefault(bi.destination, 0) + 1;
            hm1.put(bi.destination, c1);
        }


        HashMap<String, Double> hm2 = new HashMap<String, Double>();
        for(Booking bi : bl){
            double total1 = hm2.getOrDefault(bi.destination, 0.0) + bi.travelCost;
            hm2.put(bi.destination, total1);
        }


        for(String s : hm1.keySet()){
            System.out.println("The average for: " + s + " is " + (hm2.get(s) / hm1.get(s)));
        }


        HashMap<String, Integer> hm3 = new HashMap<String, Integer>();
        for(Booking bi : bl){
            int c1 = hm1.getOrDefault(bi.transportType, 0) + 1;
            hm3.put(bi.transportType, c1);
        }

        System.out.println(hm3);

        HashMap<String, Integer> hm4 = new HashMap<String, Integer>();
        for(Booking bi : bl){
            int c1 = hm1.getOrDefault(bi.packageCategory, 0) + 1;
            hm4.put(bi.packageCategory, c1);
        }

        System.out.println(hm4);
        
        File f1 = new File("./booking_summary.csv");
        FileWriter fw = new FileWriter(f1);

        for(String s : hm1.keySet()){
            fw.write(s +"," + (hm2.get(s) / hm1.get(s)) + "," + hm4.get(s) + "\n");
        }
        fw.close();



    }
}