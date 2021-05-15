public class TestUnary{

	public static void main( String args[] ){
		int a=9;
		int b=-a; 
		byte bb=9;
		int ib=+bb; 
		int x=4,y=8;
		int z;
		int i=0;
		int j=i++; 
		int k=++j; 
		
		z = (x++)*(--y);
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("bb = "+bb);
		System.out.println("ib = "+ib);
		System.out.println("i = "+i);
		System.out.println("j = "+j);
		System.out.println("k = "+k);
		System.out.println("x = "+x);
		System.out.println("y = "+y);
		System.out.println("z = "+z);		
	}
}
