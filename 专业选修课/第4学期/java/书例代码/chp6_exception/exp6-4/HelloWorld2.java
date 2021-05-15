public class HelloWorld2{
		public static void main(String args[ ]){
			int i=0;
			String greetings[ ]={ "Hello World!","Hello!",
				"HELLO WORLD!!"};
			while ( i<4){
				try {
						System.out.println(greetings[i]);
						i++;
					}catch(ArrayIndexOutOfBoundsException e){}
			}
		}
}
