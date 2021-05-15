class Alpha {
    private int iamprivate;
    
    public Alpha( int i){
    	iamprivate=i;
    }
    
    boolean isEqualTo(Alpha anotherAlpha) {
        if (this.iamprivate == anotherAlpha.iamprivate)
            return true;
        else
            return false;
    }
   }
   
public class Test{
   public static void main(String args[]){
       Alpha aa=new Alpha(10);
       Alpha bb=new Alpha(12);
       
       if(aa.isEqualTo(bb)){
       	 System.out.println("equal ");
       }
	   else{
	      System.out.println("not equal ");
	   }
  }
}


