package dp;

// 정수 삼각형
// https://programmers.co.kr/learn/courses/30/lessons/43105
public class IntegerTriangle {
	public static int solution(int[][] triangle) {
		int[][] temp = new int[triangle.length][triangle.length];

		// 초기값(출발)
		temp[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			temp[i][0] = temp[i - 1][0] + triangle[i][0];
			temp[i][i] = temp[i - 1][i - 1] + triangle[i][i];
		}
		// 끝라인 값 도출
		for (int i = 2; i < triangle.length; i++)
			for (int j = 1; j < i; j++)
				temp[i][j] = Math.max(temp[i - 1][j - 1], temp[i - 1][j]) + triangle[i][j];

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
