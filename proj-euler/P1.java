public class P1 {

	public static void main(String a[]){
		int n;
		int count = 0;
		int increment = 1;
		while (3*increment < 1000) {
			
			count+=3*increment;	
			increment+=1;
		//System.out.println(count);
			
		}
		increment = 1;
		int m; 
		while (5*increment < 1000) {
			if (!(5*increment%3==0))
			count+=5*increment;	

			increment+=1;
		//System.out.println(count);
		
		}
		System.out.println(count);
	}	
}
