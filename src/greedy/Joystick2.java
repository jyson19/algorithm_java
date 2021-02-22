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
package greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Joystick2 {

//	private String[] alphabet1 = { "A" };

	public static int solution(String name) {
		String[] alphabet2 = { "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" };
		String[] alphabet3 = { "Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O" };

		String reverseName = (new StringBuffer(name)).reverse().toString();

		// 우측 탐색 배열
		String[] rightArray = name.split("");
//		for (String a : rightArray) {
//			System.out.printf(a);
//		}
//		System.out.println();

		// 좌측 탐색 배열
		String[] leftArray = reverseName.split("");

		String temp = leftArray[leftArray.length - 1];
		for (int i = 0; i < leftArray.length - 1; i++) {
			leftArray[leftArray.length - (i + 1)] = leftArray[leftArray.length - (i + 2)];
		}
		leftArray[0] = temp;
//		for (String b : leftArray) {
//			System.out.printf(b);
//		}
//		System.out.println();

		Deque<String> rightQue = new ArrayDeque<>();
		for (int i = 0; i < rightArray.length; i++) {
			rightQue.addLast(rightArray[i]);
		}
		System.out.println("rightQue : " + rightQue);

		Deque<String> leftQue = new ArrayDeque<>();
		for (int i = 0; i < leftArray.length; i++) {
			leftQue.addLast(leftArray[i]);
		}
		System.out.println("leftQue : " + leftQue);

		
		
		
		
		// 우측 탐색
		int rCurCnt = 0; // 커서 이동 카운트
		int rAlpCnt = 0; // 알파벳 변경 카운트
		int rightCnt = 0;

		
		while (!rightQue.isEmpty()) {
			try {
				
				// 남은게 전부 A인지 체크
				Deque<String> checkQue = new ArrayDeque<>();
				for(int i = 0; i < rightQue.size(); i ++) {
					checkQue.add("A");
				}
				if(checkQue.containsAll(rightQue) == true) {
					break;
				}
				
				
				
				if (rightQue.getFirst().equals("A")) {
					rightQue.poll();
					rCurCnt++;
				} else if (Arrays.asList(alphabet2).contains(rightQue.getFirst())) {
					for (int i = 0; i < alphabet2.length; i++) {
						if (rightQue.getFirst().equals(alphabet2[i])) {
							rightQue.poll();
							rCurCnt++;
							rAlpCnt += (i + 1);
						}
					}
				} else if (Arrays.asList(alphabet3).contains(rightQue.getFirst())) {
					for (int j = 0; j < alphabet3.length; j++) {
						if (rightQue.getFirst().equals(alphabet3[j])) {
							rightQue.poll();
							rCurCnt++;
							rAlpCnt += (j + 1);
						}
					}
				}
			} catch (NoSuchElementException e) {
				break;
			}

		}
		rightCnt = rCurCnt + rAlpCnt - 1;
		System.out.println("최종 rightCnt : " + rightCnt);

		
		
		
		
		// 좌측 탐색
		int lCurCnt = 0; // 커서 이동 카운트
		int lAlpCnt = 0; // 알파벳 변경 카운트
		int leftCnt = 0;

		
		while (!leftQue.isEmpty()) {
			try {
				
				// 남은게 전부 A인지 체크
				Deque<String> checkQue = new ArrayDeque<>();
				for(int i = 0; i < leftQue.size(); i ++) {
					checkQue.add("A");
				}
				if(checkQue.containsAll(leftQue) == true) {
					break;
				}
				
				
				
				
				if (leftQue.getFirst().equals("A")) {
					lCurCnt++;
					leftQue.poll();
				} else if (Arrays.asList(alphabet2).contains(leftQue.getFirst())) {
					for (int k = 0; k < alphabet2.length; k++) {
						if (leftQue.getFirst().equals(alphabet2[k])) {
							leftQue.poll();
							lCurCnt++;
							lAlpCnt += (k + 1);
						}
					}
				} else if (Arrays.asList(alphabet3).contains(leftQue.getFirst())) {
					for (int l = 0; l < alphabet3.length; l++) {
						if (leftQue.getFirst().equals(alphabet3[l])) {
							leftQue.poll();
							lCurCnt++;
							lAlpCnt += (l + 1);
						}
					}
				}
			} catch (NoSuchElementException e) {
				break;
			}
		}
		leftCnt = lCurCnt + lAlpCnt - 1;
		System.out.println("최종 leftCnt : " + leftCnt);

		int answer = 0;
		answer = leftCnt <= rightCnt ? leftCnt : rightCnt;
		System.out.println("최종 answer : " + answer);
		return answer;
	}

	public static void main(String[] args) {
//		solution("ABAAA"); // 2:7, AAAAAAB
//		solution("JAN"); // 23 : 24, JNA
//		solution("JEROEN"); // 56, JNEORE
//		solution("ABCDEFG"); //27, AGFEDCB
		solution("AABAAAAAAABBB"); // 답 : 11 ----- 16 : 15, ABBBAAAAAAABA
	}

}
