import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class ShowAWTButton extends Applet
                          implements  ActionListener {
    
    private Frame myAWT = new GUIWindow("AWT 组件显示窗口 " );
    
    
    public void init() {
	  
	  Button myButton = new Button(" 单击此处观看AWT所有组件");
	  myButton.addActionListener(this);
	  add(myButton);
	
    }

    
     public  void actionPerformed(ActionEvent event) {
        
        if(myAWT.isVisible())
        	myAWT.setVisible(false);
        else{
        	myAWT.setSize(500,300);
        	myAWT.setVisible(true);
        }
    }
}



// 定义AWT组件显示窗口。
class GUIWindow extends Frame
                       implements ActionListener {
   
    final String FILEDIALOGMENUITEM = "File dialog...";

    public GUIWindow(String title) {
    	super( title);//系统在创建子类的对象时，要调用父类的构造方法，如果子类的构造方法中
    	//不指定，缺省将调用不带参数的父类构造方法。
        Panel bottomPanel = new Panel();
        Panel centerPanel = new Panel();
        setLayout(new BorderLayout());

        //设置菜单
        MenuBar mb = new MenuBar();
        Menu m = new Menu("Menu");
        m.add(new MenuItem("Menu item 1"));
        m.add(new CheckboxMenuItem("Menu item 2"));
        m.add(new MenuItem("Menu item 3"));
        m.add(new MenuItem("-"));

	    MenuItem fileMenuItem = new MenuItem(FILEDIALOGMENUITEM);
	    fileMenuItem.addActionListener(this);
        m.add(fileMenuItem);

        mb.add(m);
        setMenuBar(mb);

        //在窗口的底部摆放一个panel，该panel上容纳多个组件。
        bottomPanel.add(new TextField("TextField"));
        bottomPanel.add(new Button("Button"));
        bottomPanel.add(new Checkbox("Checkbox"));
        Choice c = new Choice();
        c.add("Choice Item 1");
        c.add("Choice Item 2");
        c.add("Choice Item 3");
        bottomPanel.add(c);
        add("South", bottomPanel);

        //在窗口中间摆放一个panel，该panel上容纳多个组件。
        centerPanel.setLayout(new GridLayout(1,2));
        
        centerPanel.add(new MyCanvas());
        
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add("North", new Label("Label", Label.CENTER));
        p.add("Center", new TextArea("TextArea", 5, 20));
        centerPanel.add(p);
        add("Center", centerPanel);

        //在窗口右侧摆放list.
        List l = new List(3, false);
        for (int i = 1; i <= 10; i++) {
            l.add("List item " + i);
        }
        add("East", l); 

	addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                
                dispose();
            } 
         });
    }

 
   // 当用户选择"FileDialog" 菜单项时，调用该方法显示一个文件对话框。
  public void actionPerformed(ActionEvent event) {
  
        FileDialog fd = new FileDialog(this, "FileDialog");
        fd.setVisible(true);
    }

  
}

// 在画布上显示简单的几何图形。
class MyCanvas extends Canvas {

    public void paint(Graphics g) {
        int w = getSize().width;
        int h = getSize().height;
        g.drawRect(0, 0, w - 1, h - 1);
        g.drawString("Canvas", (w - g.getFontMetrics().stringWidth("Canvas"))/2,
                      10);

        g.setFont(new Font("Helvetica", Font.PLAIN, 8));
        g.drawLine(10,10, 100,100);
        g.fillRect(9,9,3,3);
        g.drawString("(10,10)", 13, 10);
        g.fillRect(49,49,3,3);
        g.drawString("(50,50)", 53, 50);
        g.fillRect(99,99,3,3);
        g.drawString("(100,100)", 103, 100);
    }

   
}