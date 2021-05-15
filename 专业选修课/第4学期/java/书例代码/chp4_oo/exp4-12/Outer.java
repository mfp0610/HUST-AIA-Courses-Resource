public class Outer{ 
	private int size;

	/** 定义内部类Inner */
	public class Inner{ 
	
		private int size;
	
		public void doStuff(int size){ 
			size++; //存取局部变量
			this.size++;  //存取内部类的成员变量
			Outer.this.size++; //存取其外包类Outer的成员变量
			System.out.println("size in Inner.doStuff(): "+size);
			System.out.println("size of the Inner class: "+this.size);
			System.out.println("size of the Outer class:  "+Outer.this.size);
		}
	}

	Inner i=new Inner(); //成员变量i指向Inner类的对象
	
	public void increaseSize(int s){ 
		i.doStuff(s); //调用内部类Inner的方法
	}


	public static void main(String[] a){ 
		Outer o=new Outer();
		
		o.increaseSize(10);
	}
}
