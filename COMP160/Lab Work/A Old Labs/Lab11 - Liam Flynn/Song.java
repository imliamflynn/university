public class Song{
  private String songLine;
  
  public Song(String sLine){ //constructor which alters songLine
    songLine = sLine;
  }
  
  public String toString(){ //accessor method which returns songLine
    return songLine;
  }
  
  public void process(){
    int length = songLine.length();
    System.out.println("Length is: " + length);
    System.out.println("Last character is: " + songLine.charAt(length-1));
    if (songLine.indexOf(" ", songLine.indexOf(" ") + 1) != -1){ //if statement to avoid using index's that dont exist and getting a runtime error
      int firstTwo = songLine.indexOf(" ", songLine.indexOf(" ")+1);    
      System.out.println("First two words are: " + songLine.substring(0,firstTwo));
      System.out.println("Rest of the words are: " + songLine.substring(firstTwo,length));
      System.out.println("First character after the first two words: " + songLine.substring(firstTwo+1,firstTwo+2));   
    }
    System.out.println("All caps: " + songLine.toUpperCase());
    String spaceX = "";
    for (int i = 0; i < length; i++){
      if (songLine.charAt(i) == ' '){
        spaceX += "x";
      }
      else{
        spaceX += songLine.charAt(i);
      }
    }
    System.out.println("With the spaces replaced by x's: " + spaceX);
    System.out.println("Index of 'b': " + songLine.indexOf("b"));
    System.out.println(songLine);
  }
}