// 문제 설명
// 정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.
//
// 제한 조건
// num은 int 범위의 정수입니다.
// 0은 짝수입니다.

// 입출력 예
// num	return
// 3	Odd
// 4	

package basic;

public class EvenAndOdd {

	public static String solution(int num) {
		// 풀이 1
		if((num % 2)==0) {
			return "Even";
		}
		return "Odd";
		
		// 풀이 2(같은 해법)
//		return num % 2 == 0 ? "Even" : "Odd";
	}

}
