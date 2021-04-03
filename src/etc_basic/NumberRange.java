package etc_basic;

import java.util.stream.IntStream;

public class NumberRange {
	static int cnt = 0;
	public static int solution(int mod1, int mod2, int max_range) {
		IntStream.range(1, max_range + 1).forEach(i -> {
			// mod1로 나눈 나머지가 0이고,
			// mod2로 나눈 나머지가 있을때
			if(i % mod1 == 0 && i % mod2 != 0) cnt++;
		});
		return cnt;
	}
	public static void main(String[] args) {
		int mod1 = 4;
		int mod2 = 3;
		int max_range = 20;
		System.out.println(solution(mod1, mod2, max_range));
	}
}
