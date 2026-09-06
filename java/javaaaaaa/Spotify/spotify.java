/*
 * Develop a Music Streaming Application where users can listen to songs and podcasts.
 *  Each item has a title, artist/host, duration, and rating. Users can create 
 * playlists, add or remove tracks, and play them. When a user plays a track, the app
 *  should display “Now Playing: [title] by [artist]”. Each play should increase 
 * the track’s play count. Users can also rate a track, and the average rating should
 *  update accordingly. If a non-premium user tries to play a premium-only track, 
 * display a message asking them to upgrade. The admin can add or remove songs and 
 * podcasts and view the most played track overall.
 */

public class spotify{
    public static void main(String[] args) {
         songs s1 = new songs("Blank","Taylor swift",3,4.5,true);
         songs s2 = new songs("Friends","Weeknd",4,4.8,false);
         songs s3 = new songs("Let Her Go", "Passenger", 5, 4.6, false);
   
         premium_user p1 = new premium_user("Areeb", true);
         normal_user p2 = new normal_user("Heja", false);

         p1.playsong(s1);
         p1.playsong(s1);
         p1.addSong(s1);
         p1.Showplaylist();
         p1.rate_song(s1, 4);

         s1.displaySongDetails();
    }
}
