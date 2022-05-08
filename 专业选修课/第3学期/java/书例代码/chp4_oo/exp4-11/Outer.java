public class Outer{ 
	private int size;

	/** 定义内部类Inner */
	public class Inner{ 
	
		//将外包类的成员变量size递增
		public void doStuff(){ 
			size++;   
		}
	}

	Inner i=new Inner(); //成员变量i指向Inner类的对象
	
	public void increaseSize(){ 
		i.doStuff(); //调用内部类Inner的方法
	}


	public static void main(String[] a){ 
		Outer o=new Outer();
		
		for (int i = 0; i<4; i++){
		   o.increaseSize();
		   System.out.println("The value of size : "+o.size);
		}
	}
}
