import java.util.ArrayList;
import java.util.Collections;

public class P14 {
	
	public static long chainLength;
	public static long getChain() {
		return chainLength;}
	public static void setChain(long c) {
		chainLength=c;
	}
	public static int current;
	public static int getCur() {
		return current;}
	public static void setCur(int c) {
		current=c;}
	
	public static ArrayList<Integer> results = new ArrayList<Integer>(999999);
	
	//start with a number below 1 million (chain can go above it)
	//even n maps N/2  ... odd n maps 3n + 1 
	//the sequence terminates at 1	
	//find the number producing the longest chain
	//recursive calls: first off, have a global counter which will be used each time a new term is produced

	public static void main(String[] args){
		
		for (int i = 0; i<999999;i++) results.add(0);	

		setChain(1L);
		boolean switcher = true;
		//while switch=true ... and once chain length is added to, switch = false
 		long best = 0L;
		int index=0;
			
		for (long j = 1L; j < 1000000L; j++) {

			setCur((int)j);

			findChain(j);//} catch(Exception e){System.out.println("stackOverFlow :D");}
			if (getChain() > best) {best = getChain(); index=getCur();}
			//now store results for later use if we come across that number.
			results.set(getCur()-1, (int)getChain());	
			setChain(1L); //reset
			/* 	
			switcher=true;
			int i = j;
			while (switcher) {

				if (i==1) {//results.add(chainLength); 
					if (chainLength > best) { best=chainLength; index = j;}
			        	chainLength=1; switcher=false;}
	
				else { i=recurse(i); chainLength++; }	
	
				}
			}
			*/
//		 }
		}
		System.out.println(index);
	}
	
	//add a stack<> variable somehow or something to avoid this issue ?!? make a new method?
	public static void findChain(long j) {
		if ((j<getCur()) && (results.get(((int)j)-1)!=0) && (j>0)){setChain(getChain()+results.get(((int)j)-1)); return;}
		else if (j==1L) return;
		else if ((j%2L)==0) {setChain(getChain()+1L);  findChain(j/2L);}
		else {setChain(getChain()+1L); findChain(3L*j+1L);}
		//odd case will always be else ... right ... ?
		
	}
	
//	public static boolean pwr2(int i) {
//		if (i==1) return true;
//		else if (i==0||i%2!=0) return false;
//		else pwr2(i/2);
//	}

	public static int recurse(int i) { //not recursive. FAIL
		if (i%2==0)
			return i/2;
		else //(i%2==1)
			{return 3*i+1;}
	}
	
}
