'''
    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
'''
class Date:

	'''	 
	options={0 : zero(),
		1 : one(),
		2 : two(),
		3 : three(),
		4 : four(),
		5 : five(),
		6 : six(),
		7 : seven(),
		8 : eight(),
		9 : nine(),
		10 : ten(),
		11 : eleven(),
		}	
	'''

	def __init__(self, year, month, day):
		self.year = year
		self.month = month
		self.day = day
		self.dafr = self.get_dafr()

	def dotw(self):
		dotw=self.dafr
		if dotw==0:
			return "Tuesday"	
		if dotw==1:
			return "Wednesday"	
		if dotw==2:
			return "Thursday"	
		if dotw==3:
			return "Friday"	
		if dotw==4:
			return "Saturday"	
		if dotw==5:
			return "Sunday"	
		if dotw==6:
			return "Monday"	
	
	def get_dafr(self): #days away from reference - using tuesday, jan 1 1901 as our reference point
		isLeap=(self.year%4==0)

		leapyears = ((self.year-1900)/4)#uses integer division...
		
		#only count extra day for current year if past Feb. 
		if (isLeap) and (self.month<=2):
			leapyears-=1

		years = self.year-1901
		months = self.month-1

		days = self.day-1
	#	self.dafr = years*365+leapyears+options[self.month]()+days 
		self.dafr = (years*365+leapyears+self.gmid()+days)%7 
	#	print "Dotw is %s" % (self.dafr%7)
	#	print "Days past = %s" % (years*365+leapyears+self.gmid()+days)
		return self.dafr
	
	def gmid(self): #give month in days
		if self.month==1:
			return 0
		if self.month==2:      
			return 31
		if self.month==3:      
			return 59
		if self.month==4:    
			return 90
		if self.month==5:      
			return 120
		if self.month==6:      
			return 151
		if self.month==7:      
			return 181
		if self.month==8:      
			return 212
		if self.month==9:      
			return 243
		if self.month==10:     
			return 273
		if self.month==11:     
			return 304	
                if self.month==12:                  
                        return 334

def countsun():
	sum_=0
	affirm=0
	for i in range(100):
		for j in range(12):	
			affirm=0
			testday = Date(i+1901,j+1,1)
			if testday.dotw()=='Sunday':
				sum_+=1
				affirm=1
			print "%s %s %s %s" % (i+1901, j+1, testday.dotw(), affirm)
	print sum_
	return sum_

#countsun()
			
