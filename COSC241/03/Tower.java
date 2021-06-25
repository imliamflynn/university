package week03;

/**A recursive representation of a tower of blocks.
 * @author Michael Albert
 */
public class Tower{

    /**The top block.*/
    private char top;
 
    /**The rest of the tower.*/
    private Tower rest;

    /**Creates a new empty Tower.*/
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }

    /**External classes can only create empty towers and manipulate
     * them using public methods, because this constructor is
     * private.
     * @param top the top block in this tower
     * @param rest the rest of the tower*/
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**Returns true if this tower is empty, otherwise false.  Empty
     * towers are represented with the top block being a space
     * character.
     * @return whether the tower is empty or not.*/
    public boolean isEmpty() {
        return top == ' ';
    }

    /**Creates a new tower by adding the given block to the top of
     * this tower.
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.*/
    public Tower add(char block) {
        return new Tower(block, this);
    }

    /**Finds the height of the tower.
     * @return number of blocks in the tower*/
    public int height(){
        if (isEmpty()){
            return 0;
        }else{
            return 1 + this.rest.height();
        }
    }

    /**Finds how many blocks in the tower have the same char as c.
     * @param c the char we are comparing to the top blocks
     * @return the number of blocks in the tower with char c*/
    public int count(char c){
        if (isEmpty()){
            return 0;
        }else if (top == c){
            return 1 + this.rest.count(c);
        }else{
            return 0 + this.rest.count(c);
        }
    }
}
