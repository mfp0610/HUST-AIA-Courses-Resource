import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
public class MyFrameCanExit2 extends JFrame {
	public static void main(String args[ ]){
		MyFrameCanExit2 fr = new MyFrameCanExit2("Hello !");
		
		fr.addWindowListener( fr.new WindowHandler());   //×¢²á´°¿ÚÊÂ¼þ¼àÌýÆ÷¡£
		fr.setSize(200,200);				  
		fr.setVisible(true);				
	}
		  
	public MyFrameCanExit2(String str){
		super(str);
		
	}
	
	class WindowHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e) { 
    		System.exit(0);
    	}
    }
}