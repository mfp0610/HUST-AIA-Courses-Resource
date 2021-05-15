public class HelloWorld{
		public static void main(String args[ ]){
			int i=0;
			String greetings[ ]={ "Hello World!","Hello!",
				"HELLO WORLD!!"};
			while ( i<4){
				System.out.println(greetings[i]);
				i++;
			}
			System.out.println("Normal ended.");
		}
	}
