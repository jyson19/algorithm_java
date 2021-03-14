// https://programmers.co.kr/learn/courses/30/lessons/12947
package basic;

import java.util.stream.IntStream;

public class MatrixAddition {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        IntStream.range(0, arr1.length).forEach(i -> {
        	for(int j = 0; j < arr1[i].length; j++) {
        	answer[i][j] = arr1[i][j] + arr2[i][j];
        	}
        });;
        return answer;
    }

	public static void main(String[] args) {
//		int[][] arr1 = {{1,2},{2,3}};
//		int[][] arr2 = {{3,4},{5,6}};
//		System.out.println(solution(arr1, arr2)); // [[4,6],[7,9]]
		
		int[][] arr1 = {{1},{2}};
		int[][] arr2 = {{3},{4}};
		System.out.println(solution(arr1, arr2)); // [[4],[6]]
	}
}
