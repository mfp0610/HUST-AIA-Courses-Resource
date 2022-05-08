import java.util.*;

//定义Shape类
class Shape {
  void draw() {}
  void erase() {}
}

//定义Circle类
class Circle extends Shape {
  void draw() {
    System.out.println("Calling Circle.draw()");
  }
  void erase() {
    System.out.println("Calling Circle.erase()");
  }
}

//定义Square类
class Square extends Shape {
  void draw() {
    System.out.println("Calling Square.draw()");
  }
  void erase() {
    System.out.println("Calling Square.erase()");
  }
}

//定义Triangle类
class Triangle extends Shape {
  void draw() {
    System.out.println("Calling Triangle.draw()");
  }
  void erase() {
    System.out.println("Calling Triangle.erase()");
  }
}

//定义Pentagon类
class Pentagon extends Shape{
	void draw() {
    	System.out.println("Calling Pentagon.draw()");
  	}
  	void erase() {
    	System.out.println("Calling Pentagon.erase()");
  	}
 }


//包含main()的测试类
public class Shapes_2 {
  
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
       switch(rand.nextInt(4)) {
       		case 0: s[i] = new Circle();break;
      		case 1: s[i] = new Square();break;
      		case 2: s[i] = new Triangle();break;
      		case 3: s[i] = new Pentagon();break;
       }
	}
            
    drawShapes(s);
   
  }
  
} 
