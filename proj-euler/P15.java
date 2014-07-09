import java.util.ArrayList;

public class P15 {
	
	public static int gridSize=20;
	
	public static void main(String[] args){
			
		ArrayList<ArrayList<Integer[]>> paths = new ArrayList<ArrayList<Integer[]>>();
		ArrayList<Integer[]> newPath;

		int rep=0;
		//int limit = 10000000;
		int countPair[] = {0};
		boolean switchedOn = true;

		while (switchedOn) {
			
			newPath = new ArrayList<Integer[]>();
			while (!isEnd(newPath)) {
				
				//other possible optimizations would be involved in checking earlier for overlap prevention.
				//guiding where not overlapping ... 
				//THIS PART NEEDS TO BE "SMARTER" 
				//if (uniqueMove(paths, newPath)) {}
				//else {
					if (xCoord(newPath)==gridSize && yCoord(newPath)!=gridSize) {moveDown(newPath);}
					else if (yCoord(newPath)==gridSize && xCoord(newPath)!=gridSize) {moveRight(newPath);}
					else {chooseMove(newPath);}
				//}
				//if (checkBadPath(newPath)) {newPath.remove(newPath.size()-1);}
			}
			
			paths.add(newPath);
			if (uniquePath(paths)) {countPair[0] = rep;}
			else paths.remove(paths.size()-1);
		
			if (rep-countPair[0]>1000) {switchedOn = false;} //rep = limit;}
			
			rep++;
		}
		System.out.println(paths.size());
			
	}
	
	//working shittilly...
	static boolean uniqueMove(ArrayList<ArrayList<Integer[]>> paths, ArrayList<Integer[]> newPath) {

		if (paths.size()==0) return false;

		int size = newPath.size();
		ArrayList<Integer[]> test;
		for (int i=0;i<paths.size();i++){
		  if (paths.get(i).size() > size) {
			test = new ArrayList<Integer[]>();
			for (int j=0;j<size;j++)
				test.add(paths.get(i).get(j));
			if (isEqual(newPath, test)) {
				
				if ((paths.get(i).get(size)[0]==0) && (xCoord(newPath)!=gridSize)) moveRight(newPath); 
				else moveDown(newPath);
				
				return true;
			}
	          }
		}
		return false;
	}

	//make these correspond to the coordinates they add as well... i.e. 1,1 ; 0,1; 1,0	
	static void moveRight(ArrayList<Integer[]> list) {
		Integer[] R = {1,0};
		list.add(R);
	}

	static void moveDown(ArrayList<Integer[]> list) {
		Integer[] D = {0,1};
		list.add(D);
	}
	
	//gives false if it's a bad move. (either overlaps with other path, or goes out of bounds.)
	//need a method that checks it at the end, and if it matches other paths, restart ...
	static boolean checkBadPath(ArrayList<Integer[]> list) {
		int x=0; int y=0;
		for (Integer[] n : list) {
			x+=n[0]; y+=n[1];
		}
		if (x>gridSize || y>gridSize) return true; 
		else return false;
		
	}
	
	//always comparing the last one in the list to the others. 
	static boolean uniquePath(ArrayList<ArrayList<Integer[]>> lists){
		int count = lists.size();
		for (int i = 0; i <count-1; i++) {
			if (isEqual(lists.get(i), lists.get(count-1))) return false;
		}
		return true;
	}
	
	static boolean isEqual(ArrayList<Integer[]> one, ArrayList<Integer[]> two) {
		if (one.size()!=two.size()) return false;
		else {
			for (int i = 0; i<one.size(); i++) {
				if ((one.get(i)[0]==two.get(i)[0]) && (one.get(i)[1]==two.get(i)[1])){}
				else return false;
			}
		}
		return true;
	}
	
	static void chooseMove(ArrayList<Integer[]> list) {
		
		int move = (int)(Math.random()*3);
		
		switch (move) {
		case 0: case 1:
			moveRight(list); break;
		case 2: case 3: 
			moveDown(list); break;
		//moveDR(list); break;
		}
		
	}
	
	static int yCoord(ArrayList<Integer[]> list){
		
		if (list.size()==0) return 0;
		int y=0;
		for (Integer[] n : list) {
			y+=n[1];
		}
		return y;
	}
	
	static int xCoord(ArrayList<Integer[]> list){
		if (list.size()==0) return 0;
		int x=0; 
		for (Integer[] n : list) {
			x+=n[0]; 
		}
		return x;
	}
	
	//fix for the n case eventually ...
	public static boolean isEnd(ArrayList<Integer[]> list) {
		int x=0; int y=0;
		for (Integer[] n : list) {
			x+=n[0]; y+=n[1];
		}
		if (x==gridSize && y==gridSize) return true; 
		else return false;
		}


	
}
