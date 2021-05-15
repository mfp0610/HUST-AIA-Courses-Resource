class GeneralFunction{
	public static int add(int x, int y){
		return x+y ;
	}
}

public class UseGeneral{
	public static void main(String[] args){
		int c = GeneralFunction.add(9,10);
		System.out.println("9 + 10 = "+c);
	}
}


