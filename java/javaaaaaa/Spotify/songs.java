public class songs {
    String title;
    String artist;
    int duration;
    double rating;
    int playcount;
    boolean premium; // True - premium , False - not premium
    
    songs(String title,String artist,int duration, double rating,boolean premium){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.rating = rating;
        this.premium = premium;
    }

    void rate_song(int r){
        rating += r/2;
        System.out.println("The total rating of this song is: "+rating);
    }
    void displaySongDetails(){
        System.out.println(title);
        System.out.println(artist);
        System.out.println(duration);
        System.out.println("Playcount:"+playcount);
    }
}
