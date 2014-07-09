public class P7 {


	public static void main(String[] argv){
		int count = 1;
		for (long i = 3L; i < 1000000000L; i++) {
			if (isPrime(i)) {
				count++;
				if ((count==10001) && (isPrime(i))) {
					System.out.println(i);
				}
			}
		}	

	}

	public static boolean isPrime(long i) {
		for (long j = 2; j < (i/2L)+1L; j++)
			if (i%j==0) return false;
		return true;
	}

}
