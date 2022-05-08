import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL google = new URL("http://www.google.com/");
        URLConnection gl = google.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                gl.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}
