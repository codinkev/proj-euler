#include <iostream>
#include <fstream>
#include <string>
using namespace std;

//what do the little file >> foo ... things do?
/*
http://www.greenteapress.com/thinkcpp/thinkCScpp.pdf
http://www.freeprogrammingresources.com/cppbooks.html
http://www.cplusplus.com/forum/articles/12974/

http://stackoverflow.com/questions/388242/the-definitive-c-book-guide-and-list
*/

int[][] getPuzzle(int puzzle)
{
        //parameter it takes is starting line of the puzzle; returns a 2D array of the puzzle. 
	int topLine = (puzzle*10)-8;
	int[9][9] puzzle;

	string STRING;
	ifstream infile;
	infile.open ("sudoku.txt");

	int line = 0;

	while (line<puzzle*10) 
	{

		 line++; 
		 getline(infile,STRING);
 		 if (line>=topLine) 
  	 	 {  
		 			 			 	
		 	for (int i = 0; i<9; i++)
			{
				puzzle[line-2-((puzzle-1)*10)][i] = int(STRING[i]);		
			
			}
		 } //cout<<STRING<<endl; 

	}

	/*
        while(!infile.eof()) // To get you all the lines.
        {  
	        getline(infile,STRING); // Saves the line in STRING.
	        cout<<STRING<<endl; // Prints our STRING.
        }
	*/

	infile.close();
	return puzzle;
}


int main()
{
	//system ("pause");
	int[][] test = getPuzzle(1);
 	for (int i = 0; i<9; i++) {
		cout << endl;
 		for (int j = 0; j<9; j++) {
			cout << test[i][j];
		}
	}
	return 0;
}
