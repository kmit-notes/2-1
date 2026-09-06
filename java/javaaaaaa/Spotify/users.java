import java.util.ArrayList;

public abstract class users {
    String name;
    boolean premiumAccount;
    users(String name, boolean premiumAccount){
        this.name = name;
        this.premiumAccount = premiumAccount;
    }
    ArrayList<String> Playlist = new ArrayList<>();

    public void playsong(songs s){
        s.playcount+=1;
    }
    public void addSong(songs s){
        if (s.premium && premiumAccount){
        Playlist.add(s.title);
        System.out.println("Song added to Playlist.");
    }
    else {
        System.out.println("Upgrade your account to premium.");
    }
    }
    public void Showplaylist(){
        if (Playlist.isEmpty()){
            System.out.println("Your playlist is empty");
        }
        else{
            for(String x: Playlist){
                System.out.println("-"+x);
            }
        }
    }
    public void rate_song(songs s,int r){
        s.rate_song(r);
    }
}


