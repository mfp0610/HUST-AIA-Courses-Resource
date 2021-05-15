class Customer{
	private final long customerID;
	private static long counter=200901;
	
	public Customer(){
		customerID = counter++;
	}
	
	public long getID(){
		return customerID;
	}
	
	public static void main(String[] args){
		Customer [] cc = new Customer[5];
		for ( int i=0; i<cc.length; i++){
			cc[i]=new Customer();
			System.out.println("The customerID is "+cc[i].getID());
		}
	}	
	
}

