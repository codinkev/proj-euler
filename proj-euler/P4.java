public class P4 {
	
	public static void main(String a[]) {
	//find the largest palindrome made from the product of two three digit numbers. 
	//first, how large can such a product be? want to have the index of each place ...
	//upper bound: 1000*1000 has 7 digs
	//could either have 5 or 6 digits
	//lets assume it has 6 and start our bound there ... must have a combined sum (the two numbers) of 1100
	//so you could start at 101, 999 ... and then have the two meet each other. record the largest palindrome you find
	//have them start at 550 each and head to their respective ends. give the first palindrome you find. 
	//don't forget about string bufferzzzzz to reverse a given string.
		int small = 100; int large = 100; int best = 0;
		boolean stop = false; //stop when we find our first palindrome
		

		int[] first = new int[900];
		for (int i = 100; i < 1000; i++)
			first[i-100]=i;
		int[] second = first;
		
		outerloop:
		for (int j : first) { for (int n : second) {
			int result = n*j;
			if ((palindrome(result)) && (result>best)) { best = result; }	
			}
		}	
		//	break outerloop;
	/*	
		while ((small <= 999) && (stop == false)) {
				
			int result = small*large;
			//if ... best = result, stop = true.
			if (palindrome(result)) { best = result; stop = true; }
			
			else {
				small++; large++;
			}
		
		}	*/
		System.out.println(best);
	}
	
	public static boolean palindrome(int test){
		if (test/100000>0) {
		//need place 3=4 ; 2=5 ; 1=6 
		//easy to find the last placevalue ... then subtract that from number ... gives 5 ... etc.
		//have holders for each and record.
		int six = test/100000;
		int intermediary = test - six*100000;
		int five = intermediary/10000;
		intermediary = intermediary - five*10000;
		int four = intermediary/1000;
		intermediary = intermediary - four*1000;
		int three = intermediary/100;
		intermediary -= three*100;
		int two = intermediary/10;
		intermediary -= two*10;
		int one = intermediary;

		if (one==six) {
			if (five==two) {
				if (three==four) {
					return true;
				} else return false;
			} else return false;
		}
		
		else return false;
		}
		else {
		  int five = test/10000;
                  test = test - five*10000;
                  int four = test/1000;
                  test = test - four*1000;
                  int three = test/100;
                  test -= three*100;
                  int two = test/10;
                  test -= two*10;
                  int one = test;
  
                  if (one==five) {
                          if (four==two) {
                                 // if (three==four) {
                                          return true;
                                 // } else return false;
                          } else return false;
                  }
  
                  else return false;

		}
	
	}

}
