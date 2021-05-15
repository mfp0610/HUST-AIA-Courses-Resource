package graphics.twoD;

public class Rectangle {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // 定义了四个构造方法。
 /*   public Rectangle() {
		origin = new Point(0, 0);
    }
    public Rectangle(Point p) {
		origin = p;
    }
    public Rectangle(int w, int h) {
		this(new Point(0, 0), w, h);
    }*/
 public Rectangle(Point p, int w, int h) {
		origin = p;
		width = w;
		height = h;
    }

    // 移动矩形的方法。
    public void move(int x, int y) {
		origin.x = x;
		origin.y = y;
    }

    // 计算矩形面积的方法。
    public int area() {
		return width * height;
    }
}
