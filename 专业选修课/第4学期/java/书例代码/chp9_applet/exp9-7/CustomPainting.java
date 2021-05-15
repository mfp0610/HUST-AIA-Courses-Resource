import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomPainting extends JApplet {

  static String[] imageFile = {"t1.gif","t3.gif","t9.gif"};

    public void init() {
        Container c = getContentPane();
        c.setLayout(new GridLayout(1,3));
        
        for (int i=0;i<imageFile.length;i++){
            
            Image image = getImage(getCodeBase(), imageFile[i]);
            ImagePanel imagePanel = new ImagePanel(image);
        
            c.add(imagePanel);     
       }
    }
}

class ImagePanel extends JPanel {
    Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);   //»æÖÆ±³¾°

        g.drawImage(image, 0, 0, this); //»æÖÆÍ¼Ïó

 }
}

