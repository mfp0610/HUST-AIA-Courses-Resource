import java.net.*;
import java.io.*;

public class ParseURL {
    public static void main(String[] args) throws Exception {
 
        URL aURL = new URL("http://java.sun.com:80/docs/books/"
                           + "tutorial/index.html#DOWNLOADING");
        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("host = " + aURL.getHost());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("port = " + aURL.getPort());      
        System.out.println("ref = " + aURL.getRef());
    }
}
