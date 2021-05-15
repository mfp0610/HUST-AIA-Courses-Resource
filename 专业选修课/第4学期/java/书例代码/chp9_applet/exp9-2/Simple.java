import java.applet.Applet;
import java.awt.Graphics;

public class Simple extends Applet {

    StringBuffer buffer;

    public void init() {
	buffer = new StringBuffer();
        addItem("Applet初始化... ");
    }

    public void start() {
        addItem("Applet启动... ");
    }

    public void stop() {
        addItem("Applet停止运行... ");
    }

    public void destroy() {
        addItem("准备卸载...");
    }

    void addItem(String newWord) {
        System.out.println(newWord);  //将字符串输出在Java console
        buffer.append(newWord);
        repaint();
    }

    public void paint(Graphics g) {
	    g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
        g.drawString(buffer.toString(), 5, 15);
    }
}
