import java.awt.*;
import javax.swing.*;

public class BorderLayoutWindow extends JFrame {
      
    public BorderLayoutWindow() {
        setLayout(new BorderLayout());
    
 		add(new JButton("North"), "North");       
        add( new JButton("South"),"South");
        add( new JButton("East"),"East");
        add( new JButton("West"),"West");
        add( new JButton("Center"),"Center");
    }

    public static void main(String args[]) {
        BorderLayoutWindow window = new BorderLayoutWindow();
      
        window.setTitle("BorderWindow Application");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
}
