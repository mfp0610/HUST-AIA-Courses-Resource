public class VarTest{ 
	
	private int x=1;
	private int y=1;
	private int z=1;
	
	void changeVar(int a,int b,int c){ 
		x=a;
		int y = b;  //y使同名类成员变量隐藏
		int z = 9; //z使同名类成员变量隐藏
		System.out.println("In  changVar :   "+"x = "+x+" y ="+y+" z ="+z);
		this.z=c;  //给类成员变量z赋值
			
	}
	
	String getXYZ(){
		return "x = "+x+" y ="+y+" z ="+z;
	}
 	
 	
  	public static void main( String args[] ){ 
		VarTest v=new VarTest();
		System.out.println("Before changVar : "+v.getXYZ());  
	    
	    v.changeVar(10,10,10);
	    System.out.println("After changeVar: "+v.getXYZ());
	
    }
}
