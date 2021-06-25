public class SongApp{
  
  public static void main(String[]args){
    Song song1 = new Song("While my guitar gently weeps"); //creates instance of Song
    System.out.println(song1.toString());
    song1.process();
    
    System.out.println(" ");
    Song song2 = new Song("Let it be");
    System.out.println(song2.toString());
    song2.process();
    
    System.out.println(" ");
    Song song3 = new Song("Penny Lane");
    System.out.println(song3.toString());
    song3.process();
  }
}