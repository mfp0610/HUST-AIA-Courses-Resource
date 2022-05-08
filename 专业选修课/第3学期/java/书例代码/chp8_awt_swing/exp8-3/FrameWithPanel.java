	import java.awt.*;
	import javax.swing.*;
		
	public class FrameWithPanel extends JFrame {
	  	public static void main(String args[ ]){
			FrameWithPanel fr = new FrameWithPanel("Hello !");
			fr.setSize(200,200);
			fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		    
   		    JPanel pan = new JPanel();
   		    pan.setSize(200,100);
   		    pan.setBackground(Color.yellow);
   		    pan.setLayout(new GridLayout(2,1));
   		    pan.add(new JButton("È·¶¨"));
   		    fr.setContentPane(pan);

			fr.setVisible(true);
	}
	  public FrameWithPanel(String str){
		super(str);
		}
	}	