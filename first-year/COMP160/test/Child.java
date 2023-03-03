public class Child extends Parent{
    private double d;

    public Child(int x, int y, double d){
        super (x, y);
        this.d = d;
    }
    public String toString(){
        return "x = " + super.x + " y = " + super.y + " d = " + d;
    }
}