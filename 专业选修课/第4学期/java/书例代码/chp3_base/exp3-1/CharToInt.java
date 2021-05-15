public class CharToInt{
	
   public static void main(String args[]){
		
		int intResult,intVar = 10;
	    char charVar='”Ô';
	    
		intResult = intVar + charVar;
    

		System.out.println("The char is :  "+ charVar);
    
    	System.out.println("The char's Unicode is :  \\u"+Integer.toHexString(charVar));
  
    	System.out.println("The int value corresponding to the char is :  "
  						+new Integer(charVar).toString());

    	System.out.println("Int "+intVar+" adds the char, the result is :  "+intResult);

   }
}