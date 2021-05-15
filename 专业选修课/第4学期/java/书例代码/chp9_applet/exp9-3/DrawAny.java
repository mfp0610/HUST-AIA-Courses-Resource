import java.awt.* ;
import java.applet.* ;
import java.net.URL;

public class DrawAny extends Applet{
    Image im;
    public void init(){
			URL url=getDocumentBase();
      	String imageName=getParameter("image");
			im=getImage(url, imageName);
			}
    public void paint(Graphics g){
			g.drawImage(im,0,0,this);
			}
}
