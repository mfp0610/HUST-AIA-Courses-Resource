enum Coin {
	PENNY(1), NICKEL(5), DIME(10), QUARTER(25);
	
	private final int value;
	Coin(int value) { 
	    this.value = value; 
	}
	public int value() { 
	    return value; 
	}
}

enum CoinColor { COPPER, NICKEL, SILVER }

public class CoinTest {
     public static void main(String[] args) {    	        	
     	for (Coin c : Coin.values()){
			System.out.print(c + ": "+ c.value() +", ");      		     	
     		switch(c) {
     			case PENNY:
					System.out.println(CoinColor.COPPER);
					break;
     			case NICKEL:
     				System.out.println(CoinColor.NICKEL);
					break;
    			case DIME: 
     			case QUARTER:
     			    System.out.println(CoinColor.SILVER);
					break;   				     			
     		}
     	}  	
    }
}

