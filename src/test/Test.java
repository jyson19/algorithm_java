// https://programmers.co.kr/learn/courses/30/lessons/12947
package test;

import java.util.stream.LongStream;

public class Test {

    public static long[] solution(int x, int n) {
    	long[] answer = {};
//        IntStream.range(x, x*n).map(i -> i*x - x).limit(10).toArray();
//        IntStream.iterate(x, i -> i + x).limit(x*n).toArray());
        
        
        return LongStream.iterate(x, i -> i + x).limit(n).toArray();
    }

	public static void main(String[] args) {
		// 2	5	[2,4,6,8,10]
		System.out.println(solution(2, 5)); // [2,4,6,8,10]
	}
}
