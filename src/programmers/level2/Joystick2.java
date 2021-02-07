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

import java.util.ArrayDeque;
import java.util.Deque;

public class Joystick2 {

//	private String[] alphabet1 = { "A" };

	public static int solution(String name) {
		String[] alphabet2 = { "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N" };
		String[] alphabet3 = { "Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O" };
		
		String reverseName = (new StringBuffer(name)).reverse().toString();
		
		
		String[] rightArray = name.split(""); // 우측 탐색 배열
		String[] leftArray = reverseName.split("");// 좌측 탐색 배열
		
		String temp = leftArray[leftArray.length - 1];
		for(int i = 0; i < leftArray.length -1; i++) {
			leftArray[leftArray.length - (i + 1)] = leftArray[leftArray.length - (i + 2)];
		}
		leftArray[0] = temp;
		
//		System.out.println(arrayReverseName);
//		for(String b : arrayReverseName) { 
//			System.out.println(b);
//		}
		
		Deque<String> rightQue = new ArrayDeque<>();
		for(int i = 0; i < rightArray.length; i++) {
			rightQue.addLast(rightArray[i]);
		}
		Deque<String> leftQue = new ArrayDeque<>();
		for(int i = 0; i < leftArray.length; i++) {
			leftQue.addLast(leftArray[i]);
		}
		
//		rightQue.pollFirst(); // 꺼내고 삭제 후 리턴
		
		
		
		
		
		int answer = 0;
		return answer;
	}

	public static void main(String[] args) {
//		solution("AAABA"); // 3 / AABAA
//		solution("JEROEN"); // 56 / JNEORE
		solution("ABCDEFG"); // AGFEDCB
	}

}
