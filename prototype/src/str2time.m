function time = str2time(str)
%STR2TIME(str) converts time in string to integer value of time in milliseconds
	hours = str2num(substr(str, 1, 2));
	minutes = str2num(substr(str, 4, 2));
	seconds = str2num(substr(str, 7, 2));
	milliseconds = str2num(substr(str, 10, 3));
	time = ((hours*60 + minutes)*60 + seconds)*1000 + milliseconds;
end