import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class P88 {
	
	public static Integer k=2; //current count

	//this one below is mapping ([the k count]-->not the k, the min for that k) to the amount of numbers it contains (fully broken down)
	public static HashMap<Integer,Integer> prodS = new HashMap<Integer,Integer>();

	//this one below is for mapping candidate i/j to the result (will want to sort by the result to find the min Prod.Sum number)
	public static ArrayList<int[]> smallest;//= new HashMap<int[],Integer>();
 	public static ArrayList<Integer> findMin;

	public static void main(String args[]){

	int[] temp = new int[2];
	int total=0;

	 //find way to make this interval smaller???
	while (k<=12000) {
	 //k=9; //temporary check...
	 System.out.println(k);

	 smallest = new ArrayList<int[]>(); //reset each time.
	 findMin = new ArrayList<Integer>(); //

	 int l=0; //keeping the values for what maps the prodSum ...
	 int m=0;
	 boolean init=false;
         int best = 0;

 	 int limit=0;
	 if (k<20) limit=100;
	 else if (k<100) limit=1000;
	 else if (k<1000) limit=5000;
	 else if (k<5000) limit=10000;
	 else limit=15000; 

	 for (int i = 1; i<=limit; i++) {
		for (int j = 1; j<=limit; j++) {
			
				if ((k-2)+i+j==i*j) { //once we're here we've found a possible candidate
					temp[0]=i; temp[1]=j; smallest.add(temp);	
	 				findMin.add(i*j);
					if ((init) && (i*j<best)) { l=i;m=j;best=l*m; } 
					else if (!init) { l = i; m = j; init=true; best = l*m;}
			
					//System.out.println(""+i+" "+j+"");
					//System.out.println(""+i+" "+j);

				} //end if result checking
				if (((j==1000) && (i==1000)) && (temp[0]==0)) System.out.println("none found...");
		} //for i
	 }//for j
         //System.out.println(smallest); 
         		
	 Collections.sort(findMin);//figure out how to find smallest in hashMap eventually ...
	 int min = findMin.get(0); // Collections.min(smallest.values()); // catch(NoSuchElementException e) { System.out.println(prodS); }
	 //System.out.println(min);

	 //populate prodS here... before calling "contains"
	/*	
	 int l=0;
	 int m=0;
 	 //WHY, STARTING ON K=9, IS THIS AREA GIVING ME ISSUES ... 	 

	  for (int x = 0; x<smallest.size();x++) {
                  if ((smallest.get(x))[0]*(smallest.get(x))[1]==min) { 
 			temp[0] = (smallest.get(x))[0];
	                temp[1] = (smallest.get(x))[1];
			l=temp[0];
	 		m=temp[1];
		        break;
		  }
           }
	*/
	 if (k==264)
	 System.out.println(""+l+" "+m+"");// temp

	 if ((!prodS.containsKey(l)) && (!prodS.containsKey(m)))
	 {	prodS.put(min, k); }
	 else if ((prodS.containsKey(l)) && (prodS.containsKey(m))) 
	 {	prodS.put(min, (k-2)+prodS.get(l)+prodS.get(m)); }
	 else if ((prodS.containsKey(l)) && (!(prodS.containsKey(m)))) 
	 {	prodS.put(min, (k-1)+prodS.get(l)); }
	 else if ((!prodS.containsKey(l)) && ((prodS.containsKey(m)))) 
	 {	prodS.put(min, (k-1)+prodS.get(m)); }


	 //MAKE SURE THIS ISN'T COUNTING DUPLICATES DUE TO THE WAY I UPDATE K! ***
	
	 total+=min; //update our total for that k ...
	 containsPS(l,m); //move us to the next k ...
 
	
	}//while k<=12000...
 	System.out.println(total);
	}//main
	
	//this will be called with the temp we determined to contain the min value mapping...
	public static void containsPS(int l, int m) {
		int count=0;
		//check if either current i or j are product-sum numbers. would be a minimal from before.
		//hence need a new thing just holding the prod-sum found ...
		if (prodS.containsKey(l)) {
			//need type casting for Integer?
			k+=prodS.get(l);
			count++;
		}
		if (prodS.containsKey(m)) {
			k+=prodS.get(m);
			count++;
		}
		k++; //*****IS THERE A CONFLICT HERE WITH THE ++ AND SUBTRACTING COUNT WHICH I ALSO DO IN THE prodS UPDATE ... ??!?
		k-=count;
		return;
	}

} //class
