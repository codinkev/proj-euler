public class P10 {

	public static void main(String[] argv) {
	long total = 2L;
	
	for (long i=3L;i<2000000L;i++){
		if (i%2==0){}
		else if (isPrime(i)) {
//			System.out.println(i);			
			total+=i;
		}
	}	
	System.out.println(total);
	}
	
	public static boolean isPrime(long i) {
	
		for (int j=2;j<(i/3)+1;j++) {
			if (i%j==0) return false;
		}
		return true;
		}

}
