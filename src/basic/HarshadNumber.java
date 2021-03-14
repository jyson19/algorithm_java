// https://programmers.co.kr/learn/courses/30/lessons/12947
package basic;

import java.util.stream.IntStream;

public class HarshadNumber {

	static int sum = 0;
	static boolean answer = true;
    public static boolean solution(int x) {
        String xStr = x + "";
        IntStream.range(0, xStr.length()).forEach(i -> {
        	sum += Integer.parseInt(xStr.substring(i, i+1));
        	answer = x % sum == 0 ? true : false;
        });
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution(10)); // "e F d"
	}
}
