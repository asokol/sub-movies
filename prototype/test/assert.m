function assert(expected_value, actual_value)
%ASSERT(expected_value, actual_value) asserts whether given values are equal
	if expected_value != actual_value
		error(strcat("Values are not equal : expected=", num2str(expected_value), ", actual=", num2str(actual_value)));
	end
end