import java.awt.*;
import javax.swing.*;

public class GridBagLayoutWindow extends JFrame {
  
   
   /*创建标签为name的button，并使用约束对象c将
   该button加入到采用gridbag布局管理器中。*/
   protected void makebutton(String name,
                              GridBagLayout gridbag,
                              GridBagConstraints c) {
        JButton button = new JButton(name);
        gridbag.setConstraints(button, c);
        add(button);
    }

    public GridBagLayoutWindow() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
 
        setLayout(gridbag);
   
        c.fill = GridBagConstraints.BOTH;  //组件充满显示区域。
        c.weightx = 1.0;
        makebutton("Button1", gridbag, c);
        makebutton("Button2", gridbag, c);
        makebutton("Button3", gridbag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; //到行结束。
        makebutton("Button4", gridbag, c);

        c.weightx = 0.0;                   //恢复为缺省值。
        makebutton("Button5", gridbag, c); //另外一行，c.gridwidth同Button4。

        c.gridwidth = GridBagConstraints.RELATIVE; //所在行的倒数第二个组件。
        makebutton("Button6", gridbag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; //到行结束。
        makebutton("Button7", gridbag, c);

        c.gridwidth = 1;                      //恢复为缺省值。
        c.gridheight = 2;
        c.weighty = 1.0;
        makebutton("Button8", gridbag, c);

        c.weighty = 0.0;                   //恢复为缺省值。
        c.gridwidth = GridBagConstraints.REMAINDER; //到行结束。
        c.gridheight = 1;                   //恢复为缺省值。
        makebutton("Button9", gridbag, c);
        makebutton("Button10", gridbag, c);
    }
    
    public static void main(String args[]) {
        GridBagLayoutWindow window = new GridBagLayoutWindow();
 
        window.setTitle("GridBagLayoutWindow Application");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
}
