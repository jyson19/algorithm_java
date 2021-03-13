package basic;

public class CorrectParenthesis {
	boolean solution(String s) {
		boolean answer = true;
		int left = 0;
		int right = 0;
		if (s.substring(0, 1).equals(")")) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				left++;
			} else {
				right++;
			}
			if (right > left) {
				return false;
			}
		}
		if (left != right) {
			return false;
		}
		return answer;
	}
}
