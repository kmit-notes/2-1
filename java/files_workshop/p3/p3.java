/** 
  Question 3: Movie Rating System

You are given a CSV file named movies.csv that contains movie details and short text reviews.

Each row in the file has:

text
id,title,genre,boxOffice,review


Here, boxOffice is the collection amount (for example, in crores or millions).

 Star Rating Rules

Based on the review field, assign each movie a star rating from 1 to 5:

* 5 Stars – if review contains any of:
  "brilliant", "masterpiece", "must watch"
* 4 Stars – if review contains any of:
  "good", "worth watching", "entertaining"
* 3 Stars – if review contains any of:
  "average", "okay", "decent"
* 2 Stars – if review contains any of:
  "boring", "predictable", "slow"
* 1 Star – if review contains any of:
  "bad", "worst", "disappointing", "poor"

If multiple categories match in the review, choose the lowest star rating (i.e., the strongest negative dominates).
Example: "brilliant but slow and predictable" → 2 Stars (because of “slow”/“predictable”).

If no keyword matches, assign 3 Stars by default.

 Program Requirements

Write a Java program that:

1. Reads the movies.csv file using appropriate file handling classes.
2. For each record:

   * Parses id, title, genre, boxOffice, and review.
   * Computes the star rating using the rules above.
   * Stores data in a collection, e.g. ArrayList<Movie>.
3. Implements the following operations:

 (a) Sort by Box Office (Descending)

* Sort all movies by boxOffice collection, from highest to lowest.
* Display for each movie:

text
title stars review


 (b) Sort by Stars (Descending)
* First sort by stars (5 down to 1),
* For equal stars, sort by boxOffice (higher first).
* Display:

(c) Show all movies who have rating more than 3 
(d)Show the most favourtite movies
(e)Show all movies under "Drama"
(g)Show movies which were rated more but made less in box office 
(h) Display the top 3 most pofitable movies 
(i) Display all movies which starts from "S"
text
title genre stars boxOffice


---

 Sample movies.csv

csv
id,title,genre,boxOffice,review
M101,Shadow Lines,Thriller,120,Brilliant storytelling and a must watch for mystery lovers
M102,Love in Monsoon,Romance,85,Good chemistry between leads and entertaining songs
M103,Space Beyond,Sci-Fi,200,Visuals are a masterpiece but a bit slow in the middle
M104,Family Diary,Drama,60,Average story but decent performances from the cast
M105,The Last Chase,Action,175,Fast-paced and worth watching for action fans
M106,Rusty Roads,Drama,25,Boring and predictable plot with disappointing climax
M107,Comedy Nights,Comedy,95,Okay first half but good entertaining second half
M108,Dark Streets,Horror,70,Bad screenplay and one of the worst endings
M109,Dream Catcher,Fantasy,140,Quite entertaining and a good family watch
M110,Silent Echoes,Mystery,55,Slow narration and average suspense but not a bad attempt*/

package p3;
import java.io.*;
import java.util.*;3

public class p3 {
    public static void main(String[] args) {
        
        
    }
    
}
