import java.io.*;

public class StandardIO{
	public static void main(String[] args){
		String s;

		BufferedReader in = new BufferedReader(
								new InputStreamReader(System.in));

		System.out.println("Please input : ");

		try{
			s = in.readLine();
			while(!s.equals("exit")){
				System.out.println("  read: "+s);
				s = in.readLine();
			}
			System.out.println("End of Inputting.");
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}