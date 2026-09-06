/*
Question 1: Product Review Sentiment Analysis
You are given a CSV file named products.csv that contains basic information about products and their customer review text.Each row has the following fields:

id,name,brand,price,review

 Sentiment Score Rules

Based on the review field, assign each product a sentiment score (an integer) using the rules below:

* Score +2 if review contains any of:
  "excellent", "superb", "highly recommend"
* Score +1 if review contains any of:
  "good", "satisfied", "value for money"
* Score 0 if review contains any of:
  "okay", "average", "fine"
* Score -1 if review contains any of:
  "not good", "poor quality", "bad"
* Score -2 if review contains any of:
  "terrible", "worst", "never buy"

If multiple keywords appear in the same review, add all corresponding scores to get the final sentiment score.
For example, if a review contains "good" (+1) and "value for money" (+1), total score = +2.
If it contains "good" (+1) and "terrible" (-2), total score = -1.

If no keyword matches, assign a score of 0 by default.

 Program Requirements

Write a Java program that:

1. Reads the products.csv file using appropriate I/O classes (FileReader, BufferedReader, etc.).
2. For each record:

   * Parses id, name, brand, price, and review.
   * Computes the sentiment score using the rules above.
   * Stores each product in a suitable collection, e.g. ArrayList<Product>.
3. Implements the following operations:

 (a) Sort  by Price (Descending)

* Sort products:

   * Then by price (higher price first) for equal scores.
* Display the sorted list, printing for each product:

text
name brand score price review


 (b) Display Products with Negative Sentiment

* From the full list, filter only those with sentiment score < 0.
* Display:
text
name score review


(c) Display the top 5 expensive products
(d) Display the top 3 popular products 
(e) Display the names of all products with the negative rating
(f) Display the brands of the products but make sure the brand should appear only once, 
there can be multiple products of the same brand

---

 Sample products.csv

csv
id,name,brand,price,review
P101,Wireless Mouse,ClickPro,899,Excellent build quality and highly recommend for office use
P102,Gaming Keyboard,KeyMax,2499,Good feel but average key response
P103,Bluetooth Speaker,SoundWave,2799,Superb sound with great quality
P203,Bluetooth Headset ,SoundWave,4799,ok sound but poor quality plastic body
P303,Wifi Speaker,SoundWave,1799,Superb sound but poor quality plastic body
P104,Smartphone Case,ShieldIt,499,Okay fit and fine protection for daily use
P105,LED Monitor,ViewLine,8999,Terrible backlight bleeding and worst viewing angles
P106,Power Bank,ChargeAll,1299,Value for money and very good backup
P107,USB Cable,WireFlex,199,Bad connector and not good durability
P108,Noise Cancelling Headphones,SilentBeats,5499,Excellent noise cancellation and superb comfort
P109,Smartwatch,FitTime,3999,Satisfied with features but strap quality is average
P110,Laptop Stand,ErgoLift,799,Decent stand, okay stability for light laptops
P210,Laptop Charger ,ErgoLift,1799,Decent stand, great stability for laptops
P310,Night Stand,ErgoLift,799,Decent stand, excellent stability for light laptops


+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/

package p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.*;

public class p1 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("files/products.csv");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Product> parr = new ArrayList<Product>();

        String str = br.readLine();
        while (str != null) {
            String[] stra = str.split(",");
            System.out.println(stra[4]);
            String review = stra[4];
            int score = 0;
            if (review.toLowerCase().contains("excelent") || review.toLowerCase().contains("superb")
                    || review.toLowerCase().contains("highly recommend")) {
                score += 2;
            }
            if ((review.toLowerCase().contains("good") && (!review.toLowerCase().contains("not good")))
                    || review.toLowerCase().contains("satisfied") || review.toLowerCase().contains("value for money")) {
                score += 1;
            }
            if (review.toLowerCase().contains("okay") || review.toLowerCase().contains("average")
                    || review.toLowerCase().contains("fine")) {
                score += 0;
            }
            if (review.toLowerCase().contains("not ;good") || review.toLowerCase().contains("poor quality")
                    || review.toLowerCase().contains("bad")) {
                score -= 1;
            }
            if (review.toLowerCase().contains("terrible") || review.toLowerCase().contains("worst")
                    || review.toLowerCase().contains("never buy")) {
                score -= 2;
            }

            System.out.println(score);
            Product pr = new Product(stra[0], stra[1], stra[2], Integer.parseInt(stra[3]), review, score);
            parr.add(pr);
            str = br.readLine();
        }

        Collections.sort(parr, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                if (b.score != a.score) {
                    return b.score - a.score;
                } else {
                    return b.price - a.price;
                }
            }
        });


        for (Product p : parr) {
            if (p.score < 0) {
                System.out.println(p);
            }

        }

        

        Collections.sort(parr, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                    return b.price - a.price;
            }
        });

        for (int i = 0; i < 5; i++) {
            System.out.println(parr.get(i));
        }

        Collections.sort(parr, new Comparator<Product>() {
            public int compare(Product a, Product b) {
                    return b.score - a.score;
            }
        });
        
        for(int i = 0; i < 3; i++){
            System.out.println(parr.get(i));
        }

        HashSet<String> hs = new HashSet<String>();
        for(Product pr:parr){
            String brand = pr.getBrand();
            hs.add(brand);
        }
        System.out.println();
        System.out.println();
        System.out.println("Set with all unique brands");
        System.out.println(hs);

        br.close();


    }
}

class Product {
    String id;
    String name;
    String brand;
    int price;
    String review;
    int score;

    Product(String id, String name, String brand, int price, String review, int score) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.review = review;
        this.score = score;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + brand + " " + price + " " + review;
    }

    public String getBrand() {
        return brand;
    }
}