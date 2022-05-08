public class ArrayOfArraysDemo2 {
    public static void main(String[] args) {
        String[][] cartoons = {
	    	{ "Flintstones", "Fred", "Wilma", "Pebbles", "Dino" },
            { "Rubbles", "Barney", "Betty", "Bam Bam" },
            { "Jetsons", "George", "Jane", "Elroy", "Judy", "Rosie", "Astro" },
            { "Scooby Doo Gang", "Scooby Doo", "Shaggy", "Velma", "Fred", "Daphne" }
        };

        for (int i = 0; i < cartoons.length; i++) {

			System.out.print("cartoons["+i+"]"+", "+ cartoons[i].length+"elements: ");
            for (int j = 0; j < cartoons[i].length; j++) {
	        	System.out.print(cartoons[i][j] +(j<cartoons[i].length-1?", ":" "));
	        	
	    	}
	    	System.out.println();
        }
    }
}
