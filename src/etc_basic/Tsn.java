package etc_basic;

import java.util.stream.IntStream;

public class Tsn {
	static int cnt = 0;
	public static int solution(int num) {
		IntStream.range(1, num + 1).forEach(i -> {
			String a = i + "";
			if(a.contains("3") || a.contains("6") || a.contains("9"))
				cnt++;
			});
		return cnt;
	}
	public static void main(String[] args) {
//		int num = 10; // 3
//		int num = 33; // 13
		int num = 15; // 4
		System.out.println(solution(num));
	}
}
