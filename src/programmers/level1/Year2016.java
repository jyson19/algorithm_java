// 2016
//문제 설명
//2016년 1월 1일은 금요일입니다. 
//2016년 a월 b일은 무슨 요일일까요? 
//두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
//요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다. 
//예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.
//
//제한 조건
//2016년은 윤년입니다.
//2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
//입출력 예
//a	b	result
//5	24	

package programmers.level1;

import java.time.LocalDateTime;

public class Year2016 {

	public String solution(int a, int b) {
		String answer = "";
//		LocalDateTime ldt = LocalDateTime.now();
//		LocalDateTime ldt2 = null;
//		ldt2 = ldt.withYear(2016).withMonth(a).withDayOfMonth(b);
//		answer = ldt2.getDayOfWeek().toString().substring(0,3);
//		return answer;

		// way 1
//		return LocalDateTime.now().withYear(2016).withMonth(a).withDayOfMonth(b).getDayOfWeek().toString().substring(0,3);

		// way 2
		String[] month = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int[] day = {31, 29, 31, 30, 31, 30 ,31, 31, 30, 31, 30, 31};
		int i;
		if (a == 1) {
			// a, b : 1 , 1 = > FRI
			if(b % 7 == 1) {
//				answer == month[];
				
			}
		} else if (a == 2) {
			// a, b : 2 , 1 = > MON
			
		} else if (a == 3) {
			// a, b : 3 , 1 = > TUE
			
		} else if (a == 4) {
			// a, b : 4 , 1 = > FRI
			
		} else if (a == 5) {
			// a, b : 5 , 1 = > SUN
			
		} else if (a == 6) {
			// a, b : 6 , 1 = > WED
			
		} else if (a == 7) {
			// a, b : 7 , 1 = > FRI
			
		} else if (a == 8) {
			// a, b : 8 , 1 = > MON
			
		} else if (a == 9) {
			// a, b : 9 , 1 = > THU
			
		} else if (a == 10) {
			// a, b : 10 , 1 = > SAT
			
		} else if (a == 11) {
			// a, b : 12 , 1 = > THU
			
		} else if (a == 12) {
			// a, b : 11 , 1 = > TUE
			
		}

		return null;
	}

	public static void main(String[] args) {
		String answer = "";
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime ldt2 = null;
		ldt2 = ldt.withYear(2016).withMonth(12).withDayOfMonth(1);
		answer = ldt2.getDayOfWeek().toString();
		answer = answer.substring(0, 3);
		System.out.println(answer);
	}

}
