package basic;

public class CaesarCipher {
	public String solution(String s, int n) {
		String answer = "";
		
		// 알파벳 개수만큼 초기화
		n = n % 26;
		
		for (int i = 0; i < s.length(); i++) {
			char charStr = s.charAt(i);
			
			// 소문자
			if (Character.isLowerCase(charStr)) {
				charStr = (char) ((charStr - 'a' + n) % 26 + 'a');
				
				// 대문자
			} else if (Character.isUpperCase(charStr)) {
				charStr = (char) ((charStr - 'A' + n) % 26 + 'A');
			}
			answer += charStr;
		}
		return answer;
	}

	public static void main(String[] args) {
//		answer += "" + (char) (s.charAt(i) + n);
	}
}
