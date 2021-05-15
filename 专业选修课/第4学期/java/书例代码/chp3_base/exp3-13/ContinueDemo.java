public class ContinueDemo {
    public static void main(String[] args) {

        StringBuffer searchMe = new StringBuffer(
                  "peter piper picked a peck of pickled peppers");
        int max = searchMe.length();
        int numPs = 0;

        for (int i = 0; i < max; i++) {
	    
            if (searchMe.charAt(i) != 'p')
	        continue;

	    
	    numPs++;
            searchMe.setCharAt(i, 'P');
        }
        System.out.println("Found " + numPs + " p's in the string.");
        System.out.println(searchMe);
    }
}
