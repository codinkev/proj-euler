public class P3 {
	public static void main(String a[]){
		long best = 0L;
		boolean prime = false;
		boolean switcher = true;
		//600851475143 -- find the largest prime factor
		//go up to a multiple of 2 (half of it) and then check if the number itself is prime ...
		for (long i = 50000000L; switcher == true ; i--) {
			if ((600851475143L%i==0) && (i>best)) {
				prime = true;
				for (long j = 2L; ((j < (i/2)) && prime==true); j++) {
					if (i%j==0)
						prime = false;
				}
				if (prime==true){ 
					best = i;
					switcher = false;
				}
			}
		}
		System.out.println(best);
	}
}
