package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class IntegerTriangle {
	public static int solution(int[][] triangle) {
		int[][] temp = new int[triangle.length][triangle.length];

		// 초기값(출발)
		temp[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			temp[i][0] = temp[i - 1][0] + triangle[i][0];
			temp[i][i] = temp[i - 1][i - 1] + triangle[i][i];
		}

		for (int i = 2; i < triangle.length; i++)
			for (int j = 1; j < i; j++)
				temp[i][j] = Math.max(temp[i - 1][j - 1], temp[i - 1][j]) + triangle[i][j];

		// 끝라인 값 도출
//		System.out.println(temp[temp.length - 1][0]);
//		System.out.println(temp[temp.length - 1][1]);
//		System.out.println(temp[temp.length - 1][2]);
//		System.out.println(temp[temp.length - 1][3]);
//		System.out.println(temp[temp.length - 1][4]);
//		System.out.println(temp[temp.length - 1][temp.length - 1]);

		int answer = 0;
		for (int i = 0; i <= temp.length - 1; i++) {
			answer = temp[temp.length - 1][i] > answer ? temp[temp.length - 1][i] : answer;
		}
//		IntStream.range(0, temp.length-1).filter(i -> {
//			
//		});

		return answer;
	}

	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println(solution(triangle));
	}
}
