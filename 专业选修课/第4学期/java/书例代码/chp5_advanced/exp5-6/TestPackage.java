import graphics.twoD.*;


public class TestPackage{
	public static void main(String args[]){
	
		Point p=new Point(2,3);
		Rectangle r=new Rectangle(p,10,10);
		
		System.out.println("The area of the rectangle is "+r.area());
		}
	}