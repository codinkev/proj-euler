public class P2 {
	public static void main(String a[]) {

		Integer x = 1;
		Integer y = 2;
		Integer z = x + y;
		Integer[] fib = {x,y,z};
		int sum = 2;
		while (z<=4000000) {
		//sum...if
			if (z%2==0) 
				sum+=z;
			x=fib[1]; y=fib[2]; z=x+y;
			fib[0]=x;fib[1]=y;fib[2]=z;
		}
		System.out.println(sum);

	}	
}
