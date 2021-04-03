package etc_basic;

import java.util.stream.IntStream;

public class Tsn {
	public static int solution(int num) {
		// for문
//		int cnt = 0;
//		for(int i = 1; i <= num; i++) {
//			String a = i + "";
//			if(a.contains("3") || a.contains("6") || a.contains("9"))
//			cnt++;
//		};
//		return cnt;
		
		// stream
		return (int) IntStream.range(1, num + 1).mapToObj(i -> i + "").filter(i -> i.contains("3") || i.contains("6") || i.contains("9")).count();
	}
	public static void main(String[] args) {
//		int num = 10; // 3
//		int num = 33; // 13
		int num = 15; // 4
		System.out.println(solution(num));
	}
}
