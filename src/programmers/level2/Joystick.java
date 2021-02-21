//  문제 설명
//  조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
//  ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

//  조이스틱을 각 방향으로 움직이면 아래와 같습니다.
//  ▲ - 다음 알파벳
//  ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
//  ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
//  ▶ - 커서를 오른쪽으로 이동

//  예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
//  - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
//  - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
//  - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
//  따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
//  만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

//  제한 사항
//  name은 알파벳 대문자로만 이루어져 있습니다.
//  name의 길이는 1 이상 20 이하입니다.

//  입출력 예
//  name	return
//  JEROEN    56
//  JAN       23
package programmers.level2;

import java.util.Arrays;

public class Joystick {

//	private String[] alphabet1 = { "A" };

	public static int solution(String name) {
		String[] alphabet2 = { "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" };
		String[] alphabet3 = { "Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O" };

		String[] arrayName = name.split("");

		// name의 길이가 6이면
		// 기본적으로 'AAAAAA'로 세팅되어 있다
		// AAAAAA -> JEROEN 바꾸기....

		// name을 활용한 커서의 기본 구조
		// if name = DANAWA
		//
		// 커서의 위치는 항상 첫글자고, 첫글자는 끝글자와 이어짐
		// DANAWA => ANAWA'D'ANAWA

		// A기준
		// N OPQRSTUVWXYZ A BCDEFGHIJKLMN

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arrayName.length; i++) {
			sb.append(arrayName[i]);
		}
		sb.append(name);
		sb.deleteCharAt(0);

		System.out.println(sb.toString()); // AAABA AAABA

		arrayName = (sb.toString()).split("");

//		for (int i = 0; i < arrayName.length; i++) {
//			System.out.println(arrayName[i]);
//		}

		int cursorIdx = arrayName.length / 2; // 커서의 위치 인덱스
		int cursorCnt = 0; // 커서 이동횟수

		// 커서 위치를 기준으로 좌우 탐색
		int left = 0;
		int right = 0;

		if (arrayName[cursorIdx].equals("A")) {
			cursorCnt++;
		} else {
			if (Arrays.asList(alphabet2).contains(arrayName[cursorIdx])) {
				for (int j = 0; j < alphabet2.length; j++) {
					if (arrayName[cursorIdx].equals(alphabet2[j])) {
						cursorCnt += (j + 1);
					}
				}

			} else if (Arrays.asList(alphabet3).contains(arrayName[cursorIdx])) {
				for (int k = 0; k < alphabet3.length; k++) {
					if (arrayName[cursorIdx].equals(alphabet3[k])) {
						cursorCnt += (k + 1);
					}
				}
			}
		}

		// 좌측 탐색
		for (int i = 1; i < name.length(); i++) {
			if (arrayName[cursorIdx - i].equals("A")) {
				left++;
			} else {
				if (Arrays.asList(alphabet2).contains(arrayName[cursorIdx - i])) {
					for (int j = 0; j < alphabet2.length; j++) {
						if (arrayName[cursorIdx - i].equals(alphabet2[j])) {
							left += (j + 2);
						}
					}

				} else if (Arrays.asList(alphabet3).contains(arrayName[cursorIdx - i])) {
					for (int k = 0; k < alphabet3.length; k++) {
						if (arrayName[cursorIdx - i].equals(alphabet3[k])) {
							left += (k + 2);
						}
					}
				}
			}
		}
		// 좌측 탐색 끝 글자가 A일 때
		if (arrayName[cursorIdx - (name.length() - 1)].equals("A")) {
			left--;
		}
		System.out.println("좌측 탐색 값 : " + (left));

		// 우측 탐색
		for (int a = 1; a < name.length(); a++) {
//			System.out.println("커서 위치 : " + (cursorIdx + j));
			if (arrayName[cursorIdx + a].equals("A")) {
				right++;
//				System.out.println("우측 right 값 : " + right);
			} else {
				if (Arrays.asList(alphabet2).contains(arrayName[cursorIdx + a])) {
					for (int b = 0; b < alphabet2.length; b++) {
						if (arrayName[cursorIdx + a].equals(alphabet2[b])) {
							right += (b + 2);
						}
					}

				} else if (Arrays.asList(alphabet3).contains(arrayName[cursorIdx + a])) {
					for (int c = 0; c < alphabet3.length; c++) {
						if (arrayName[cursorIdx + a].equals(alphabet3[c])) {
							right += (c + 2);
						}
					}
				}
			}
		}
		// 우측 탐색 끝 글자가 A일 때
		if (arrayName[cursorIdx + (name.length() - 1)].equals("A")) {
			right--;
		}
		System.out.println("우측 탐색 값 : " + (right));
//		}

		int answer = 0;
		answer = (cursorCnt + left) <= (cursorCnt + right) ? (cursorCnt + left) : (cursorCnt + right);

		System.out.println("답" + answer);
		return answer;
	}

	public static void main(String[] args) {
//		solution("AAABA"); // 3
		solution("JEROEN"); // 56
	}

}
