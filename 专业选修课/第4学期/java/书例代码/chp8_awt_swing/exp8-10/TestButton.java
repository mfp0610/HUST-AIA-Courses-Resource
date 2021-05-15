import java.awt.*;
import java.awt.event.* ;
import javax.swing.*;

public class TestButton{
    public static void main(String args[ ]){
		JFrame f = new JFrame("Test");
		f.setSize(200,100);
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton b = new JButton("Press Me!");
		b.addActionListener(new ButtonHandler( )); //注册点击鼠标事件监听器。
		
		f.add(b);
		f.setVisible(true) ;
	}
 }

//定义ActionEvent监听器类
class ButtonHandler implements ActionListener{

    public void actionPerformed(ActionEvent e){
		System.out.println("Action occurred");
		System.out.println("Button's label is:"+
		                       e.getActionCommand());
		}
	}