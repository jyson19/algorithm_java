// https://programmers.co.kr/learn/courses/30/lessons/12928
package basic;

import java.util.stream.IntStream;

public class FactorsSum {
	static int sum = 0;

	public static int solution(int n) {
		IntStream.range(1, n + 1).forEach(i -> {
			sum = (n % i) == 0 ? sum + i : sum;
		});
		return sum;
	}
}
