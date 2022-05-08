class Dog {
	private int weight ;
	
	public Dog(){
		weight = 42 ;
	}
	
	public int getWeight(){
		return weight;
	}
	public void setWeight(int newWeight){
		weight = newWeight;
	}
	
}

public class UseDog{
	public static void main(String[] args){
		Dog d = new Dog();
		System.out.println("The dog's weight is "+ d.getWeight());
	}
}
		 