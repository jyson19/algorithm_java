package basic;

import java.util.stream.IntStream;

public class CaesarCipher_stream {
	// a-z : 97~122
	// A-Z : 65~90
	static String answer = "";

	public static String solution(String s, int nm) {
		int n = nm % 26;
		IntStream.range(0, s.length()).forEach(i -> {
			char charStr = s.charAt(i);
			if (charStr != ' ') {
				charStr = Character.isLowerCase(charStr) ? (char) ((charStr - 'a' + n) % 26 + 'a')
						: (char) ((charStr - 'A' + n) % 26 + 'A');
				answer += charStr;
			} else {
				answer += charStr;
			}
		});
		return answer;
	}

	public static void main(String[] args) {
//		System.out.println(solution("AB", 1)); // "BC"
//		System.out.println(solution("z", 1)); // "a"
		System.out.println(solution("a B z", 4)); // "e F d"
	}
}
