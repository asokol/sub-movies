function [start_time, end_time] = str2time_span(str)
%STR2TIME_SPAN(str) converts "00:00:01,000 --> 00:00:04,074" into pair [1000, 4074]
	time_len = length("HH:mm:ss,MMM");
	arrow_len = length(" --> ");
	start_str = substr(str, 1, time_len);
	end_str = substr(str, time_len + arrow_len + 1, time_len);
	start_time = str2time(start_str);
	end_time = str2time(end_str);
end