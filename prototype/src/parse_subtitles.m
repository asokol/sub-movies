function time_spans = parse_subtitles(filename)
%PARSE_SUBTITLES(FILENAME)	Parses subtitles file and loades time spans of subtitles
% Return [n x 2] matrix. Each row is (start_time, end_time)
	fid = fopen (filename);
	time_spans = [];
	txt = fgets(fid);	
	count = 0;
	while txt != -1
		pos = index(txt, '-->');
		if pos > 0
			[start_time, end_time] = str2time_span(txt);			
			time_spans(end + 1, 1) = start_time;
			time_spans(end, 2) = end_time;			
		end
		txt = fgets(fid);
	end
		  
	fclose (fid);
end