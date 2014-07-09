import java.util.HashMap;

public class P44 {

	public static void main(String[] args) {

	//pentagonal numbers: some number that = n(3n-1)/2
	//n must be natural number
	//find the two pentagonal numbers such that their distance between em is minimized, AND their sum/dif = a pentagonal number. 

	//to find one of these: for int i,
	//...... 1.5n^2 -.5n
//	double test = 1.5*5*5 - .5*5;
//	int tested = (int)(test);
//	System.out.println(tested);

	int[] pentHold = new int[4000];
	int index = 0;
		for (int i = 1; pentHold[3999]<1; i++) {
			if (isPent(i)) { pentHold[index]=i; index++; }//*/System.out.println(i);}  
		}
	
//	for (int b = 0; b<100; b++)
//		System.out.println(pentHold[b]);
	int prevB=0; //gap holder for current D (answer)
	boolean initialized=false;; //before prevB initialized
	//check indexes already compared
	//obviously, just check i+j sucks. but checking the distance of the iTH with the jTH ... ? AND their sum. 
	//or could just check if either j maps to i or i maps to j.
	HashMap<Integer,Integer> checker = new HashMap<Integer,Integer>();	

	for (int i : pentHold) {
		for (int j : pentHold) {
	
		if (notChecked(i,j,checker) && (i!=j)) {

			checker.put(i,j);

			if (i>j) { 
			if ((isPent(i-j)) && (isPent(i+j))) {if (!initialized) {prevB=i-j; initialized=true;} else if (i-j<prevB){ prevB=i-j;}
			 }}
			if (i<j) {
			if ((isPent(j-i)) && (isPent(i+j))) {if (!initialized) {prevB=j-i; initialized=true;} else if (j-i<prevB){ prevB=j-i;}
			}

		}
		}
	}
}
	
	System.out.println(prevB);

	}

	public static boolean isPent(int test) {
		double testConv = (double)(test/1.0);
	 			     //might need to go higher
		double divisor;
		if (testConv>1000000) divisor = 1000.0;
		else if (testConv>100000) divisor = 330.0;
		else if (testConv>10000) divisor = 100.0;
		else if (testConv>1000) divisor = 50.0;
		else if (testConv>100) divisor = 10.0;
		else divisor = 1.0;

		for (double i = 1.0; i<(testConv/divisor); i++)	{
			if ((1.5*i*i - .5*i)==testConv) return true;			
		}	
		return false;
	}

	public static boolean notChecked(int i, int j, HashMap<Integer,Integer> check) {
		if ((!check.containsKey(i))&&(!check.containsKey(j))) return true;
	//	boolean firstTry=false;
	//	boolean secondTry=false;
		if (check.containsKey(i)) {
			if (check.get(i)==j) return false;// else firstTry = true;
		}	
		if (check.containsKey(j)) {
			if (check.get(j)==i) return false;// else secondTry = true;
		}
	//	if ((firstTry == true) && (secondTry == true)) { return true;} else return false; 
		return true;
	}




}
