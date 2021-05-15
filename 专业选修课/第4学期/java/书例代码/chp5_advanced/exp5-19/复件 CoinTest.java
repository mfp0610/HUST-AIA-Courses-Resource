 enum CoinColor { COPPER, NICKEL, SILVER }
 
 enum Coin {
	PENNY(1,CoinColor.COPPER), 
	NICKEL(5,CoinColor.NICKEL), 
	DIME(10,CoinColor.SILVER), 
	QUARTER(25,CoinColor.SILVER);
	
	private final int value;
	private final CoinColor color;
	Coin(int value, CoinColor color) { 
		this.value = value; 
		this.color = color;
	}
	public int value() { return value; }
	public CoinColor color(){ return color;} 
}

public class CoinTest {
     public static void main(String[] args) {
     	
 // System.out.println(": "+"  "+Coin.PENNY.value());   	
     	for (Coin c : Coin.values())
     	System.out.println(c + ": "+ c.value() +", " + c.color());
    }
}
    	 
   





/* enum Coin {
	PENNY(1), NICKEL(5), DIME(10), QUARTER(25);
	
	private final int value;
	Coin(int value) { this.value = value; }
	public int value() { return value; }
}

public class CoinTest {
     public static void main(String[] args) {
     	
 // System.out.println(": "+"  "+Coin.PENNY.value());   	
     	for (Coin c : Coin.values())
     	System.out.println(c + ": "+ c.value() +"? " +
     	color(c));
    	 }
    	 
    private enum CoinColor { COPPER, NICKEL, SILVER }
     
    private static CoinColor color(Coin c) {
     switch(c) {
     	case PENNY:
//  	        System.out.println("in switch: "+c+"  "+Coin.PENNY.value());
     		return CoinColor.COPPER;
     	case NICKEL:
    		return CoinColor.NICKEL;
     	case DIME: case QUARTER:
     		return CoinColor.SILVER;
     	default:
     		throw new AssertionError("Unknown coin: " + c);
     }
     }
}

*/