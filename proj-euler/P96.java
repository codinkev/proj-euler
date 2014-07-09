import java.io.BufferedReader;
import java.io.FileReader;

/* EXAMPLE...
BufferedReader fh =
new BufferedReader(new FileReader("sudoku.txt"));
String s;
while ((s=fh.readLine())!=null)
System.out.println(s);
fh.close();
}*/ //LEARN MORE ABOUT THIS "THROWS EXCEPTION" BULLCRAP WHERE NEEDED/HOW USE BEST... 

public class P96 { //sudoku ... reading txt file etc...

	public static void main(String[] argv) throws Exception{
		
		//int[][] puzzle = getPuzzle(1); 
		printPuzzle(getPuzzle(1));
		//System.out.println(sumCorner(getPuzzle(1)));
		
	}

	public static int[][] getPuzzle(int puzzleNumber) throws Exception {
		
		//50 puzzles total.
		int topLine = (puzzleNumber*10)-8;
        	int[][] puzzle = new int[9][9];
		//int[] converted = new int[9]; //used for populating each part of the 2D as we iterate

		BufferedReader fh = new BufferedReader(new FileReader("sudoku.txt"));
    		String lineContent;
        	int line = 0;

        	while (line<puzzleNumber*10)
        	{
                 line++;
                 lineContent=fh.readLine();
		 if (line>=topLine) {
                        for (int i = 0; i<9; i++) { 
			 int holder = Character.getNumericValue(lineContent.charAt(i));        
			 //converted[i] = holder;  
			 puzzle[line-2-((puzzleNumber-1)*10)][i] = holder;                     
			}
                 } 
       		}//while	
        	fh.close();
        	return puzzle;
	}

	public static void printPuzzle(int[][] puzzle) {
		for (int i = 0; i<9;i++){
			if (i>0) System.out.println("");
			for (int j=0;j<9;j++) {
				System.out.print(puzzle[i][j]);
				if ((i==8) && (j==8)) System.out.println("");
			}
		}
	}

	public static int sumCorner(int[][] puzzle) {
		int number = puzzle[1][1]*100 + puzzle[1][2]*10 + puzzle[1][3];
		return number;
	}

	
	//return a solved version of thine puzzockladee -- will prob. require a lot of helper methods
	public static int[][] solvePuzzle(int[][] puzzle) {
		return null;	


	}

	//pass true if checking a row, false if checking a column. which is the row/column being checked
	public static int[] contains(int[][] puzzle, int which, boolean row) {
		int[] container = new int[10];		
		if (row) {
			for (int i=0;i<9;i++) {
				container[puzzle[which][i]] = puzzle[which][i];
			}
		} else {
			for (int i=0;i<9;i++) {
				container[puzzle[i][which]] = puzzle[i][which];
			}
		}
		return container;		

	}

}

