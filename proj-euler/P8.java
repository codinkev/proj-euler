import java.io.BufferedReader;
import java.io.FileReader;

public class P8 {

	public static void main(String[] argv) throws Exception {
		int best = 0;
		String test = createString();
		//System.out.println(test);
		for (int i = 0; i < (test.length())-5; i++) {
			int one = Character.getNumericValue(test.charAt(i));
			int two = Character.getNumericValue(test.charAt(i+1));
			int three = Character.getNumericValue(test.charAt(i+2));
			int four = Character.getNumericValue(test.charAt(i+3));
			int five = Character.getNumericValue(test.charAt(i+4));
	
			int product = one*two*three*four*five;

			if (product>best) best = product;				
		}	
		
		System.out.println(best);	
	}

	public static String createString() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("long.txt"));
		String s;
		String result = "";
		while ((s=reader.readLine())!=null) {
			result+=s;
		}
		return result;
	}
}
