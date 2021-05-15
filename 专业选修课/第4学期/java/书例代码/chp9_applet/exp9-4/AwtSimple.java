import java.applet.Applet;
import java.awt.TextField;

public class AwtSimple extends Applet {

    TextField field;

    public void init() {
        
        field = new TextField();
        field.setEditable(false);
        System.out.println(field.getColumns());

        
        setLayout(new java.awt.GridLayout(1,0));

        
        add(field);
        validate();  

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
        String t = field.getText();
        System.out.println(newWord);
        field.setText(t + newWord);
    }
}
