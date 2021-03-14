package test;

import java.util.stream.IntStream;

public class Test {
	static int sum = 0;

	public static int solution(int n) {
		IntStream.range(1, n + 1).forEach(i -> {
			sum = (n % i) == 0 ? sum + i : sum;
		});
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(solution(12));
	}
}
