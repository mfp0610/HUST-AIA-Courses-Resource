public class TestInit{
  int x;
  
  public static void main(String args[]){
	TestInit init = new TestInit();
    
    int x = (int)(Math.random()*100);
   	int z ;
//  	int y =0 ; 
    int y ;
  	
  	if (x > 50){
  		y=9; 
    }
 
    z = x + y + init.x;
    
    System.out.println("x="+x+" y="+y+" z="+z+" init.x="+init.x);
 
  }
}