class Outer{ 
	private int size;

	/** 定义内部类Inner */
	class Inner{ 
	    void doStuff(){ 
			size++;  
			System.out.println("The size value of the Outer class: "+size); 
		}
	}
}

public class TestInner{
	public static void main(String[] a){ 
		Outer out=new Outer();
		Outer.Inner in=out.new Inner(); //声明并创建内部类的对象
	
		in.doStuff();  //调用内部类的方法
	}
}
