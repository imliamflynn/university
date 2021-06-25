package week02; import java.util.Random;

/** Lab 2, March 13th.
 *@author Liam Flynn*/
public class Coins{
    
    /**final data field.*/
    public static final boolean HEADS = true;
    
    /**final data field.*/
    public static final boolean TAILS = false;
    
    /**data field.*/
    private boolean[] coins;
    
    /**main method. @param args  */
    public static void main(String[] args){}
    
    /**constructor, sets coins data field to coins input.
     *@param coins is an array of booleans*/
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    
    /**constructor, takes a string of 'H's and 'T's and fills
     *the coins array accordingly.
     *@param s string of 'H's and 'T's*/
    public Coins(String s){
        this.coins = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'H'){
                coins[i] = HEADS;
            }else if(s.charAt(i) == 'T'){
                coins[i] = TAILS;
            }
        }
    }
    
    /**constructor, takes an int argument and sets the array to
     *that size, then fills it with random booleans.
     *@param length int which sets array length*/
    public Coins(int length){
        this.coins = new boolean[length];
        Random rand = new Random();
        for (int x = 0; x < length; x++){
            int coinFlip = rand.nextInt(2);
            if (coinFlip == 0){
                coins[x] = HEADS;
            }else{
                coins[x] = TAILS;
            }
        }
    }
    
    /**countHeads method counts the number of HEADS/trues
     * in the coins array.
     * @return the number of heads*/
    public int countHeads(){
        int heads = 0;
        for(boolean x:coins){
            if (x == HEADS){
                heads ++;
            }
        }
        return heads;
    }
    
    /**countRuns method counts the number of runs in the coins array.
     *@return the number of runs*/
    public int countRuns(){
        int count = 1;
        for (int i = 1; i < coins.length; i++){
            if (coins[i] == coins[i-1]){
            }else{
                count++;
            }
        }
        return count;
    }
    
    /**returns a string representing the coins array but 'H's
     *for true and 'T's for false.
     *@return string representing the coins array with 'H's and 'T's*/
    public String toString(){
        String s = "";
        for (int i = 0; i < coins.length; i++){
            if (coins[i] == HEADS){
                s += "H";
            }else{
                s += "T";
            }
        }
        return s;
    }
}
