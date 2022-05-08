import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

		URL google = new URL("http://www.google.com/index.html");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(google.openStream()));

		String inputLine;

		while ((inputLine = in.readLine()) != null)
	    	System.out.println(inputLine);

		in.close();
    }
}
