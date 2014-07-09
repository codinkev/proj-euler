import java.io.FileReader;
import java.io.BufferedReader;

public class P11 {

	public static void main(String argv[]) throws Exception{
	
		int[][] numbers = getArray();
		int best = 0;

		for (int i=0;i<numbers[0].length;i++) {
			System.out.println("");
			for (int j=0;j<numbers[0].length;j++) {
				//System.out.print(numbers[i][j]+" ");
				int result = getAdjSum(numbers, i, j);
				if (result > best) best = result;
			}
		}
		
		System.out.println(best);			

	}

	public static int[][] getArray() throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader("11.txt"));
		String line="";

		int[][] nums = new int[20][20];
		int row = 0; int column = 0;

		while ((line=reader.readLine())!=null) {
			column = 0;
			String[] numbers = line.split(" ");
			for (String s : numbers) {
				nums[row][column] = Integer.valueOf(s);
				column++;
			}
			row++;
		}
		reader.close();

		return nums;
	}

	public static int getAdjSum(int[][] array, int row, int column) {
		
		//we care about 8 directions: get the 8 diagonal products and return the largest one
		//FOR THAT PARTICULAR ENTRY ... 
		int best = 0;

		//make sure each check falls within the bounds of the grid
		
		//dir left
		if (column-3>=0){
			int result = array[row][column]*array[row][column-1]*array[row][column-2]*array[row][column-3];
			if (result > best) best = result;		
		}
		//dir right
		if (column+3<=19){
			int result = array[row][column]*array[row][column+1]*array[row][column+2]*array[row][column+3];
                        if (result > best) best = result; 
		}
		//dir UL
		if ((column-3>=0) && (row-3>=0)){
			int result = array[row][column]*array[row-1][column-1]*array[row-2][column-2]*array[row-3][column-3];
                        if (result > best) best = result; 
		}
		//dir UR
		if ((column+3<=19) && (row-3>=0)) {
			int result = array[row][column]*array[row-1][column+1]*array[row-2][column+2]*array[row-3][column+3];
                        if (result > best) best = result; 
		}
		//dir up
		if (row-3>=0) {
			int result = array[row][column]*array[row-1][column]*array[row-2][column]*array[row-3][column];
                        if (result > best) best = result; 
		}
		//dir down
		if (row+3<=19) {
			int result = array[row][column]*array[row+1][column]*array[row+2][column]*array[row+3][column];
                        if (result > best) best = result; 
		}
		//dir DL
		if ((row+3<=19) && (column-3>=0)) {
			int result = array[row][column]*array[row+1][column-1]*array[row+2][column-2]*array[row+3][column-3];
                        if (result > best) best = result; 
		}
		//dir DR	
		if ((row+3<=19) && (column+3<=19)) {
			int result = array[row][column]*array[row+1][column+1]*array[row+2][column+2]*array[row+3][column+3];
                        if (result > best) best = result; 
		}

		return best;
	}
}
