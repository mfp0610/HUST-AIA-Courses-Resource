import java.awt.*;
import javax.swing.*;

public class FlowLayoutWindow extends JFrame {
      
    public FlowLayoutWindow() {
        setLayout(new FlowLayout());
        add(new JLabel("Buttons:"));
        add(new JButton("Button 1"));
        add(new JButton("2"));
        add(new JButton("Button 3"));
        add(new JButton("Long-Named Button 4"));
        add(new JButton("Button 5"));
        
    }
 
    public static void main(String args[]) {
        FlowLayoutWindow window = new FlowLayoutWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("FlowLayoutWindow Application");
        window.pack();//窗口的大小设置为适合组件最佳尺寸与布局所需的空间。
        window.setVisible(true);
    }
}
