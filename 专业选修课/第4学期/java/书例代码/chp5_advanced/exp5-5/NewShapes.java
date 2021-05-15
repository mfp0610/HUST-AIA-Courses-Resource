import java.util.*;

//将Shape定义为interface
interface Shape {
   void draw();
   void erase();
}

//定义Circle类实现Shape
class Circle implements Shape {
  public void draw() {
    System.out.println("Calling Circle.draw()");
  }
  public void erase() {
    System.out.println("Calling Circle.erase()");
  }
}

//定义Square类实现Shape
class Square implements Shape {
  public void draw() {
    System.out.println("Calling Square.draw()");
  }
  public void erase() {
    System.out.println("Calling Square.erase()");
  }
}

//定义Triangle类实现Shape
class Triangle implements Shape {
   public void draw() {
    System.out.println("Calling Triangle.draw()");
  }
   public void erase() {
    System.out.println("Calling Triangle.erase()");
  }
}


//包含main()的测试类
public class NewShapes{
  
  static void drawOneShape(Shape s){
  	s.draw();
  }
  
  static void drawShapes(Shape[] ss){
  	 for(int i = 0; i < ss.length; i++){
        ss[i].draw();
    }
  }
  	
 public static void main(String[] args) {
  	Random rand = new Random();
    Shape[] s = new Shape[9];
   
    for(int i = 0; i < s.length; i++){
       switch(rand.nextInt(3)) {
       		case 0: s[i] = new Circle();break;
      		case 1: s[i] = new Square();break;
      		case 2: s[i] = new Triangle();break;
       }
	}
            
    drawShapes(s);
   
  }
  
} 
