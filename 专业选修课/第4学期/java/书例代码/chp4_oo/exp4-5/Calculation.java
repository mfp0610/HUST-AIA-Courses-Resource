public class Calculation {
	public float avg(int... nums) {
		int sum = 0;
		for ( int x : nums ) {
			sum += x;
		}
		return ((float) sum) / nums.length;
	}
	
	public static void main(String args[]){
		Calculation cal = new Calculation();
		float average1 = cal.avg(10, 20, 30);
        float average2 = cal.avg(5, 6, 7, 8, 9, 10);
        System.out.println("The average of 10,20,30 is"+" "+average1);
        System.out.println("The average of 5, 6, 7, 8, 9, 10 is"+" "+average2);
	}
}

