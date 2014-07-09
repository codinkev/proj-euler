public class P5 {

	public static void main(String[] args) {

	// find the smallest number which is evenly divisible by 1 - 20
	//we know that 2520 is the smallest divisible by 1 thru 10...
	boolean stop = false;
	int[] twent = new int[20];
	for (int j=1;j<21;j++)
		twent[j-1]=j;
	int result=0; //store answer
	for (int i=4000;stop==false;i++) {
		for (int n : twent) {
			if (i%n!=0) break;
			if (n==20) { result = i; stop=true; }
		}

	}	
	System.out.println(result);
	}

}
