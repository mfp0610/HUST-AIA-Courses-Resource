import javax.swing.*;
import java.awt.*;

public class SwingSimple extends JApplet {

    JTextField jField;

    public void init() {
       
        Container contentPane = getContentPane();
        
        jField = new JTextField();
        jField.setEditable(false);
        
        contentPane.setLayout(new GridLayout(1,0));
        contentPane.add(jField);
        addItem("初始化... ");
    }

    public void start() {
        addItem("启动... ");
    }

    public void stop() {
        addItem("停止... ");
    }

    public void destroy() {
        addItem("准备卸载...");
    }

    void addItem(String newWord) {
        String t = jField.getText();
        System.out.println(newWord);
        jField.setText(t + newWord);
    }
}

