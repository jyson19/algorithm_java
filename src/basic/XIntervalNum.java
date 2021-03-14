// https://programmers.co.kr/learn/courses/30/lessons/12947
package basic;

import java.util.stream.LongStream;

public class XIntervalNum {

    public static long[] solution(int x, int n) {
        return LongStream.iterate(x, i -> i + x).limit(n).toArray();
    }

	public static void main(String[] args) {
		// 2	5	[2,4,6,8,10]
		System.out.println(solution(2, 5)); // [2,4,6,8,10]
	}
}
