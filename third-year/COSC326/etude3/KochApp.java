import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * Liam Lennon-Flynn
 * April 2022
 * COSC326 - Etude 3 - Koch Snowflake
 * This program is the application class for a visual representation of a Koch Snowflake
 */

public class KochApp {
    static JFrame frame;
    static KochPanel panel;

    /** Creates a frame and adds KochPanel to it. Also listens for when the window is resized and remakes and adds panel to frame*/
    public static void main(String[] args){
        panel = new KochPanel(500, 500, 0);
        frame = new JFrame("Koch Snowflake");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        frame.getContentPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                frame.getContentPane().remove(panel);

                double w = frame.getWidth();
                double h = frame.getHeight();
                int i = panel.getInputNum();

                panel = new KochPanel(w, h, i);

                frame.getContentPane().add(panel);
                frame.validate();
            }
        });
    }
}
