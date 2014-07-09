"""
the n^th tri. num is the sum of the first n natural numbers
find the first one that has >500 factors (ie, 6 has 4 factors 1236).
"""

def main():
	number=0
	swapped = True
	while (swapped):
		number=number+1
		if (findFactorCount(triNum(number))>500):
			print triNum(number)
			swapped=False	

def triNum(count):
	#gives the *count*^th triangular number ...
	return (count*(count+1))/2

def findFactorCount(number):
	count=0
	#insert a particular triangular number to see its number of factors
	for x in range(number):
		if (number%(x+1)==0):
			count+=1
	return count	

main()
