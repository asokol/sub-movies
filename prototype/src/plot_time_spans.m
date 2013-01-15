function [ ] = plot_time_spans(time_spans)
% PLOT_TIME_SPANS(TIME_SPANS) plots time spans on 1-D graph
figure;
x = time_spans(:, 1);
y = time_spans(:, 2);
plot(x, y, '*');
end