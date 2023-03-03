import java.math.*;
import java.awt.*;
import javax.swing.*;

/**
 * Liam Lennon-Flynn
 * April 2022
 * COSC326 - Etude 3 - Koch Snowflake
 * This is the class that acts as a segment of a Koch Snowflake. Many instances of this class get made.
 */
public class Segment {
    private double ax, ay, bx, by;

    /** Constructor stores parameters in datafields.*/
    public Segment(double a1, double a2, double b1, double b2){
        ax = a1;
        ay = a2;
        bx = b1;
        by = b2;
    }

    /** This method calculates the length that each segment needs to be
     * and adds each segment to an array which is returned.*/
    public Segment[] create(){
        Segment[] pieces = new Segment[4];

        double[] working = sub(bx, by, ax, ay);
        working = div(working[0], working [1], 3);

        double[] b1 = add(ax, ay, working[0], working[1]);
        pieces[0] = new Segment(ax, ay, b1[0], b1[1]);

        double[] a1 = sub(bx, by, working[0], working[1]);
        pieces[3] = new Segment(a1[0], a1[1], bx, by);

        working = rotate(working[0], working[1], Math.PI / 3);
        double[] c1 = add(b1[0], b1[1], working[0], working[1]);
        pieces[1] = new Segment(b1[0], b1[1], c1[0], c1[1]);
        pieces[2] = new Segment(c1[0], c1[1], a1[0], a1[1]);

        return pieces;
    }

    /** This method draws each line of the Koch Snowflake.*/
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawLine((int)ax, (int)ay, (int)bx, (int)by);
    }

    /** This method adds one point to another.*/
    public double[] add(double x1, double x2, double y1, double y2){
        double x = x1 + y1;
        double y = x2 + y2;
        double[] result = {x, y};

        return result;
    }

    /** This method subtracts one point from another.*/
    public double[] sub(double x1, double x2, double y1, double y2){
        double x = x1 - y1;
        double y = x2 - y2;
        double[] result = {x, y};

        return result;
    }

    /** This method divides one point by a number.*/
    public double[] div(double x1, double x2, double div){
        double x = x1 / div;
        double y = x2 / div;
        double[] result = {x, y};

        return result;
    }

    /** This method rotates a point by an angle.*/
    public double[] rotate(double x, double y, double angle) {
        double temp = x;
        x = x * Math.cos(angle) - y * Math.sin(angle);
        y = temp * Math.sin(angle) + y * Math.cos(angle);
        double[] result = {x, y};

        return result;
    }
}
