public class P9 {

	public static void main(String argv[]){
		
		for (int i = 1; i < 500; i++) {
			for (int j = 1; j < 500; j++) {
				for (int k = 1; k < 500; k++) {
					if ((i+j+k==1000) && (i*i+j*j==k*k))
						System.out.println(i*j*k);	
				}
			}
		}	

	}

}
