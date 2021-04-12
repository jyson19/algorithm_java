package basic;

// 삼각 달팽이
// https://programmers.co.kr/learn/courses/30/lessons/68645?language=java
public class TriangularSnail {
	// 전체 갯수
	// 4 : 10
	// 5 : 15
	// 6 : 21
	// n : n(n+1)/2

	public static int[] solution(int n) {
		int[] answer = new int[(n * (n + 1)) / 2];
		int[][] matrix = new int[n][n];

		int x = -1, y = 0;
		int num = 1;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i % 3 == 0) {
					x++;
				} else if (i % 3 == 1) {
					y++;
				} else if (i % 3 == 2) {
					x--;
					y--;
				}
				matrix[x][y] = num++;
			}
		}

		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0)
					break;
				answer[k++] = matrix[i][j];
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 6; // 1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11
		System.out.println(solution(n));
	}
}
