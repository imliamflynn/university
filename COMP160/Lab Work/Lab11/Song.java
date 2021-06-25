/** lenli455 
  * Lab 11, Song.java
  * Liam Flynn, August 2020
  * Stores a song line as its data field and performs tasks on it 
  * when the process method is called
  */

public class Song{
  private String songLine;
  
  /** Replacement for default constructor */
  public Song(){}
  
  /** This mutator constructor changes the data field to its parameter */
  public Song(String sLine){
    songLine = sLine;
  }
  
  /** Accessor returns the datafield */
  public String toString(){
    return songLine;
  }
  
  /** Does a series of tasks on the datafield */
  public void process(){
    int firstSpace = songLine.indexOf(' ');
    int secondSpace = songLine.indexOf(' ', firstSpace + 1);
    System.out.println("Length is: " + songLine.length());
    System.out.println("Last character: " + songLine.charAt(songLine.length()-1));
    System.out.println("All caps: " + songLine.toUpperCase());
    System.out.println("' ' replaced by '_': " + songLine.replace(' ','_'));
    System.out.println("First occurrence of k: " + songLine.indexOf('k'));
    System.out.println(songLine);
    
    if (secondSpace != -1){
    System.out.println(songLine.substring(0, secondSpace));
    System.out.println(songLine.substring(secondSpace + 1));
    System.out.println("First letter of third word: " + songLine.substring(secondSpace + 1, secondSpace + 2));
    }
    
    System.out.println(" ");
    
  }
}