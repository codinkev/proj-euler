public class P33 {

	public static void main(String a[]) {
	//there are four 2-dig-over-2-dig fractions (less than one) where the digits cancel out in an odd way (ie 49/98 also happens to be 4/8)
	//find all 4, multiply them, then give the fraction in lowest terms and report the denom. 

	//let's find em:
		//go from 00/01 all the way up ... increment by one each time ... 
		//rule: couldn't cancel in the one's spot for BOTH. needs to be each in the off-hand position
		// ij/lm     -->   10*i + j ; 10*l + m
		// if i = m or j = l AND the fraction == some x/y (x/y also < 1 obviously) then we have a match (in which case, print)				
		int count = 0; //help terminate more quickly
		//int i = 0; int j = 0; int l = 0; int m = 1;
		//first lets try to see how many pop out with just doing -- 49/98 types. nested for loop to bring all j's up ... try with each lm
		int[] numez = new int[99];
		for (int g = 1; g <= 99 ; g++)
			numez[g-1] = g;
		int[] denom = numez;
		double tester;
		double smallTest;
		//single testers 
		int[] smallN = {1,2,3,4,5,6,7,8,9};
		int[] smallD = smallN;

		int numOnes = 0;

		//need to test EACH member of this array over EACH member of the array (lolz)
		for (int j : denom) {
			for (int i : numez) {

			if (i<10) numOnes  = i;
			else if (i<20) numOnes = i-10;
			else if (i<30) numOnes = i-20;	
			else if (i<40) numOnes = i-30;
			else if (i<50) numOnes = i-40;
			else if (i<60) numOnes = i-50;
			else if (i<70) numOnes = i-60;
			else if (i<80) numOnes = i-70;
			else if (i<90) numOnes = i-80;
			else if (i<100) numOnes = i-90;

			if (i<j) {
				tester = ((double)(i/1.0))/j;
				int denomTens = j/10;
				double denomTensD = denomTens/1.0;
				if (numOnes==denomTens) {
					System.out.println("numOnes: " + numOnes + "; denomTens: " + denomTens);			
					for (int n : smallD) {
						for (int m : smallN) {
							if (m < n) {
							smallTest = ((double)(m/1.0))/n;
							if ((tester==smallTest)) {// && ( ( (double)((i-numOnes)/1.0)/((j-denomTens*10)/1.0) ) == smallTest ) ) {
								count+=1; 
								System.out.println("count is " + count + "; num is " + i + "; denom is " + j);
							}	
							}		
						}
					}
				}
			}
			} 	
		}	
	}
}
