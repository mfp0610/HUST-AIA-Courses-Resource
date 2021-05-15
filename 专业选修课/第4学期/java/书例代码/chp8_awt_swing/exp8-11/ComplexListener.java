import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComplexListener implements 
	    MouseMotionListener, MouseListener,ActionListener{
	JFrame f;
	JTextArea tf;
	JButton bt;
	int number=1;
   
	
	public ComplexListener(){
		JLabel label=new JLabel("click and Drag the mouse");
		f=new JFrame("Complex Listener");
		tf=new JTextArea();
    	bt = new JButton("退出");
	    
	    tf.addMouseMotionListener(this);
		tf.addMouseListener(this);   
	    bt.addActionListener(this);
	    
	    f.add(label,BorderLayout.NORTH);
	    f.add(tf,BorderLayout.CENTER);
	    f.add(bt,BorderLayout.SOUTH);		
		f.setSize(300,200);
		f.setVisible(true);
	}

	// MouseMotionListener 的方法。
	public void mouseDragged(MouseEvent e){ 
		String s = number+++" "+"The mouse Dragged: x= "+e.getX()+" y="+e.getY()+"\n";
		tf.append(s);
	}

	//MouseListener 的方法。
	public void mouseEntered(MouseEvent e){
		String s = number+++" "+"The mouse entered"+"\n";
		tf.append(s);
	}

	public void mouseClicked(MouseEvent e){ 
		String s = number+++" "+"The mouse clicked."+"\n";
		tf.append(s);
	}

	public void mouseExited(MouseEvent e){
		String s =number+++" "+ "The mouse exit."+"\n";
		tf.append(s);
	}

	// 未使用的 MouseMotionListener 方法。.
	public void mouseMoved(MouseEvent e){ }

	// 未使用的 MouseListener 方法。
	public void mouseReleased(MouseEvent e){ }
	public void mousePressed(MouseEvent e){ }
	
	//ActionListener的方法。
	public void actionPerformed(ActionEvent e){
		System.exit(0);
	}

	public static void main(String args[]){
		ComplexListener two = new ComplexListener( );
	}
}
