import java.util.*;

class Cage<E> extends LinkedList<E>{}; 

class Animal{
  public void feedMe(){ };
} 
 
class Lion extends Animal{
	public void feedMe(){
		System.out.println("Feeding lions");
	}
}

class ButterFly extends Animal{
	public void feedMe(){
		System.out.println("Feeding butterflies");
	}
}

public class WildcardsTest{

	public static void main(String args[]){
		
		WildcardsTest t = new WildcardsTest();
		
		Cage<Lion> lionCage = new Cage<Lion>();
		Cage<ButterFly> butterflyCage = new Cage<ButterFly>();
		lionCage.add(new Lion());
		butterflyCage.add(new ButterFly());
		
		t.feedAnimals(lionCage);
		t.feedAnimals(butterflyCage);
	}
	
	void feedAnimals(Cage<? extends Animal> someCage) {
	    for (Animal a:someCage)
		   a.feedMe();
	}
		
}