//문제 설명
//0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
//
//예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
//
//0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
//
//제한 사항
//numbers의 길이는 1 이상 100,000 이하입니다.
//numbers의 원소는 0 이상 1,000 이하입니다.
//정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
//입출력 예
//numbers	return
//[6, 10, 2]	6210
//[3, 30, 34, 5, 9]

// 주어진 수가 3개일 때 3! = 3*2*1 = 6;
// 주어진 수가 4개일 때 4! = 4*3*2*1 = 24;
// 주어진 수가 5개일 때 5! = 5*4*3*2*1 = 120;

package programmers.level2;

public class maxNumber {

	public String solution(int[] numbers) {
        String answer = "";
        
        int len; // 주어진 수의 갯수
        for(int i = numbers.length - 1; i >= 0; i--) {
        	len = numbers[i] * numbers[i - 1];
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] a = {5,2,20,3,1}; // 5*4*3*2*1 = 120
		int len1 = 0;
		int len2 = 0;
		 for(int i = a.length; i > 1; i--) {
	        	len2 = i * (i-1);
	        	len1 *= len2;
	        }
		System.out.println(len1);
	}
}
