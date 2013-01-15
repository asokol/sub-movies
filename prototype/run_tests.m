%directories
src_dir = "./src";
test_dir = "./test";
addpath(src_dir);
addpath(test_dir);
%run tests
%parse_subtitles_test
plot_time_spans_test

