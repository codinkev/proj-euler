#what are the sum of the digits for 2^1000
#look more at list comprehension and how to append to list...
x=2**1000
y=''+str(x)
list_ = []
sum_it = 0
for char in y:
#	print char + ' ' + str(ord(char))
#	print ord(char)
	print int(char)
	sum_it += int(char)

print sum_it

