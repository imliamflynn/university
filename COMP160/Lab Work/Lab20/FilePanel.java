import java.awt.*; import javax.swing.*; import java.io.*; import java.util.Scanner;

/** Lab 20, FilePanel.java
  * Liam Flynn, September 2020
  * a JPanel which creates 2 instances of Rectangle objects,
  * stores them in an array, and draws them
  */

public class FilePanel extends JPanel{
  private Rectangle[] drawObjects = new Rectangle [10];
  private int count;
  
  
  /**constructor instantiates 6 Rectangle objects*/
  public FilePanel(){ 
    String fileName = "LongBadData.txt";
    try{
      Scanner fileScan = new Scanner(new File(fileName));
      while (fileScan.hasNextLine() && count < 10){
        String inputLine = fileScan.nextLine();
        if (inputLine.matches("\\d+ [1-3] \\d+ \\d+ \\d+ \\d+")){
          Scanner scan = new Scanner(inputLine);
          int fill = scan.nextInt();
          boolean fillBoo = false;
          if (fill == 1){
            fillBoo = true;
          }
          int colorInt = scan.nextInt();
          Color recColor = Color.black;
          if (colorInt == 1){
            recColor = Color.red;
          }
          else if (colorInt == 2){
            recColor = Color.blue;
          }
          else if (colorInt == 3){
            recColor = Color.green;
          }
          int x = scan.nextInt();
          int y = scan.nextInt();
          int width = scan.nextInt();
          int height = scan.nextInt();
          drawObjects[count] = new Rectangle(fillBoo, recColor, x, y, width, height);
          count++;
        }
      }
    }
    catch (FileNotFoundException e){
      System.out.println("File not found. Check file name and location.");
      System.exit(1);
    }
    //drawObjects[count] = new Rectangle(true,Color.red, 0, 0,30,30);
    //count++;
    //drawObjects[count] = new Rectangle(false,Color.blue, 50, 50,30,30);
    //count++;
    setPreferredSize(new Dimension(300,300));
    setBackground(Color.yellow);
  }
  
  /**each Rectangle will draw itself*/
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i = 0; i < count; i++){
      drawObjects[i].draw(g);
    }
  }
}