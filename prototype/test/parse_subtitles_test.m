%parse subtitles
filename = "data/TheMatrix.srt";
time_spans = parse_subtitles(filename);
quantity = size(time_spans)(1);
assert(1368, quantity)
fprintf('Test parse_subtitles successfully passed. \n');