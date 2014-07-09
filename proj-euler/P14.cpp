//insights thus far: if it's a power of 2 it divides right down to 1 so we don't check those.
//if it's first 3n+1 goes to a power of 2 we also don't.
//now learn some c++...

//http://www.cplusplus.com/doc/tutorial/program_structure/
//http://pages.cs.wisc.edu/~hasti/cs368/JavaTutorial/NOTES/Java_vs.html
//pointers: http://www.cplusplus.com/doc/tutorial/pointers/

#include <iostream> //anytime we plan to use cout << 
using namespace std; //avoid using std::cout; e.g.; each time. 

//class First {
  void printEm() {
	cout << "Hello world" << endl;
	//return 0;
  } 
//anytime want a void function, have void fcn_name(void):
int main() {
  printEm();
// cout << "Hello world" << endl;
 return 0;
}

//};
