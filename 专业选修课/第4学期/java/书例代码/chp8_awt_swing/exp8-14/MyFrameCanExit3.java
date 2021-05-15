import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
public class MyFrameCanExit3 extends JFrame {
	public static void main(String args[ ]){
		MyFrameCanExit3 fr = new MyFrameCanExit3("Hello !");
		
		fr.addWindowListener( new WindowAdapter(){
				public void windowClosing(WindowEvent e) { 
    				System.exit(0);
    			}
    	});   //×¢²á´°¿ÚÊÂ¼þ¼àÌýÆ÷¡£
		fr.setSize(200,200);				   
		fr.setVisible(true);				
	}
		  
	public MyFrameCanExit3(String str){
		super(str);
	}	
}