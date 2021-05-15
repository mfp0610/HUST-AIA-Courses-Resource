public class AutoBoxingTest{

    public static void main(String args[]){

		Integer x, y;
		int c;
		x = 22;
		y = 15;
		
		if ( (c = x.compareTo(y)) == 0)
			 System.out.println("x is equal to y");
		else
		     if ( c < 0 )
		         System.out.println("x is less than y");
		     else
		         System.out.println("x is greater than y");
			        
		System.out.println("The sum of x and y is "+(x+y) );
    }
}
