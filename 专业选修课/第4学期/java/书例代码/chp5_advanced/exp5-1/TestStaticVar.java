class Count{
	private int serialNumber ;
	public static int counter = 0 ;

	public Count( ){
		counter++ ;
		serialNumber = counter ;
		}
	public int getSerialNumber(){
		return serialNumber;
	}
}

public class TestStaticVar{
	
  public static void main(String[] args){
  	Count[] cc = new Count[10];
  	for(int i=0;i<cc.length;i++){
  		cc[i]=new Count();
  		System.out.println("cc["+i+"].serialNumber = "+cc[i].getSerialNumber());
  	}
  }
}
  		
