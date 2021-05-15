public class PassTest{
	float ptValue;
	
	//参数类型是基本类型
	public void changeInt(int value){
		value = 55 ; 
	}
	
	//参数类型是引用型，并且方法中改了变参数的值
	public void changeStr(String value){
		value = new String("different"); 
	}
	
	//参数类型是引用型，并且方法中改了变参数所指向对象的成员变量值
	public void changeObjValue( PassTest ref){
		ref.ptValue = 99.0f; 
	}
	
	public static void  main(String args[ ] ){
		String str;
		int val;
		
		PassTest pt= new PassTest( );  //创建PassTest的对象
		
		//测试基本类型参数的传递，观察调用程序中的变量值是否改变
		val = 11;
		pt.changeInt(val);
		System.out.println("Int value is: " +val);

		//测试引用类型参数的传递，观察调用程序中的变量值是否改变		
		str = new String("Hello");
		pt.changeStr(str);
		System.out.println("Str value is: " +str);
		
		//测试引用类型参数的传递，观察调用程序中的变量值是否改变		
		pt.ptValue = 101.0f ;
		pt.changeObjValue(pt);
		System.out.println("Pt value is: " +pt.ptValue);
	}
}
