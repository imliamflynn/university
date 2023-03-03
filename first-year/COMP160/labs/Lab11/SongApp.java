/** lenli455
  * Lab 11, SongApp.java
  * Liam Flynn, August 2020
  * Application class for Song.java, creates instances
  */

public class SongApp{
  
  public static void main(String[]args){
    Song song1 = new Song("While my guitar gently weeps");
    Song song2 = new Song("Let it be");
    Song song3 = new Song("Penny Lane");
    
    System.out.println(song1);
    song1.process();
    
    System.out.println(song2);
    song2.process();
    
    System.out.println(song3);
    song3.process();
  }
}