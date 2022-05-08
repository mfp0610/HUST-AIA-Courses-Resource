import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;

public class Click extends Applet 
			 implements MouseListener {

    int num=0;

    public void init() {
	  addMouseListener(this);
	         
    }

    
    public void paint(Graphics g) {
	
        g.drawRect(0, 0, 
		   getSize().width - 1,
		   getSize().height - 1);

	       g.drawString(" 鼠标在此点击   "+num+" 次", 5, 15);
    }

    
    public void mouseEntered(MouseEvent event) {
    }
    public void mouseExited(MouseEvent event) {
    }
    public void mousePressed(MouseEvent event) {
    }
    public void mouseReleased(MouseEvent event) {
    }

    public void mouseClicked(MouseEvent event) {
	    num++;
	    repaint();
    }
}
