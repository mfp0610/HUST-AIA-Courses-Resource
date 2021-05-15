import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutWindow extends JFrame implements ActionListener {
      
    JPanel cards;
    CardLayout CLayout=new CardLayout();
 
    public CardLayoutWindow() {
        setLayout(new BorderLayout());  //设置Frame为BorderLayout。
  
       //创建摆放"卡片切换"按钮的panel,并添加到Frame中。
        JPanel cp = new JPanel();
        JButton bt = new JButton("卡片切换");
        bt.addActionListener(this);
        cp.add(bt);
        add("North", cp);
        
        //创建承放多个卡片的Panel，设置为CardLayout。
        cards = new JPanel();  
        cards.setLayout(CLayout);  
        
        //创建cards中的第一个panel及其组件。
        JPanel p1 = new JPanel();    
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        p1.add(new JButton("Button 3"));

        //创建cards中的另一个panel及其组件。
        JPanel p2 = new JPanel();
        p2.add(new JTextField("TextField", 20));

        //把上述两个panel加到cards中。
        cards.add("Panel with Buttons", p1);
        cards.add("Panel with TextField", p2);
        
        //将cards放入Frame中。
        add("Center", cards);
    }

   //响应点击切换卡片按钮的事件。
   public void actionPerformed(ActionEvent e){
     CLayout.next(cards); //显示下一张卡片。
   }

   public static void main(String args[]) {
        CardLayoutWindow window = new CardLayoutWindow();
       
        window.setTitle("CardWindow Application");
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
