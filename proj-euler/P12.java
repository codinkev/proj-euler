/*
find the first triangular number with >500 factors
*/

public class P12 {

	public static void main(String argv[]){
	    boolean switc = true;		
	    for (int i=1; switc; i++) {		
		int result = findFact(triNum(i));
		//if (i<50) System.out.println(""+result+" "+triNum(i));
	    	if (result>500) {
		        System.out.println(""+result+" "+triNum(i));
			switc = false;
		}
	    }
	}

	public static int triNum(int count){
		//return the "count^th" triangular number
		return (count*(count+1))/2;
	}

	public static int findFact(int num) {
		int count=0; //all numbers have at least themselves as a factor
			     //also have 1 as factor...
		int divisor = 1;
		for (int i=1;i<(num/divisor);i++) {
			if (num%i==0) {
			   if (i*i==num) count+=1;
		           else count+=2;
			   divisor=i;
			}
		}
		return count;
	}

}
