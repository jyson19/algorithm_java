package kakao;
//문제 설명

import java.util.regex.Pattern;

// 신규아이디 추천

public class newID {
	public static String solution(String new_id) {
		// 사용 가능한 단어
		// 알파벳 소문자,
		// 숫자,
		// 빼기(-),
		// 밑줄(_),
		// 마침표(.)
		String answer = "";
		answer = new_id;

		// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		answer = answer.toLowerCase();

		// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		String engPattern = "^[a-z]*$";
		String numPattern = "^[0-9]*$";
//        String minusPattern = "^[-]*$";
//        String underBarPattern = "^[_]*$";
//        String dotPattern = "^[.]*$";

		String newAnswer = "";
		for (int i = 0; i < answer.length(); i++) {
			char ansList = answer.charAt(i);
			boolean regex = Pattern.matches(engPattern, Character.toString(ansList));
			if (regex == true) {
				newAnswer += Character.toString(ansList);
			}

			regex = Pattern.matches(numPattern, Character.toString(ansList));
			if (regex == true) {
				newAnswer += Character.toString(ansList);
			}

			if (Character.toString(ansList).equals("-") | Character.toString(ansList).equals("_")
					| Character.toString(ansList).equals(".")) {
				newAnswer += Character.toString(ansList);
			}

		}

		System.out.println("2단계 : " + newAnswer);

		// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		do {
			newAnswer = newAnswer.replace("..", ".");
		} while (newAnswer.contains(".."));

		System.out.println("3단계 : " + newAnswer);

		// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		if (newAnswer.length() > 0) {
			if (newAnswer.charAt(0) == '.') {
				newAnswer = newAnswer.substring(1, newAnswer.length());
			}
		}
		if (newAnswer.length() > 0) {
			if (newAnswer.charAt(newAnswer.length() - 1) == '.') {
				newAnswer = newAnswer.substring(0, newAnswer.length() - 1);
			}
		}

		System.out.println("4단계 : " + newAnswer);

		// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if (newAnswer.equals("")) {
			newAnswer = "a";
		}

		System.out.println("5단계 : " + newAnswer);

		// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (newAnswer.length() >= 16) {
			newAnswer = newAnswer.substring(0, 15);
			if (newAnswer.charAt(newAnswer.length() - 1) == '.') {
				newAnswer = newAnswer.substring(0, newAnswer.length() - 1);
			}
		}

		System.out.println("6단계 : " + newAnswer);

		// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		if (newAnswer.length() <= 2) {
			while (!(newAnswer.length() == 3)) {
				newAnswer = newAnswer.concat(newAnswer.substring(newAnswer.length() - 1));
			}
		}

		System.out.println("7단계 : " + newAnswer);

		answer = newAnswer;
		return answer;
	}

	public static void main(String[] args) {
//		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
//		System.out.println(solution("z-+.^.")); // z--
		System.out.println(solution("=.="));
//		System.out.println(solution("123_.def"));
//		System.out.println(solution("abcdefghijklmn.p"));
	}
}
