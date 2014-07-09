public class P6 {
	public static void main(String argv[]) {
		long sumSq;
		long sqSum=0L;
		
		sumSq = 50*101; //n*n+1/2
		sumSq*=sumSq; //square the sum
	
		for (long i = 0L ; i <= 100L ; i++)
			sqSum += i*i;	

		long result = sqSum-sumSq;
		System.out.println(result);
	}
}
