package basic;

import java.util.stream.IntStream;

public class CorrectParenthesis_stream {
	static boolean check = true;
	static int count = 0;

	static boolean solution(String s) {
		IntStream.range(0, s.length()).forEach(i -> {
			count = (s.charAt(i) == '(') ? (count + 1) : (count - 1);
			if (count < 0) {
				check = false;
			}
		});
		if (count != 0) {
			check = false;
		}
		return check;
	}
}
