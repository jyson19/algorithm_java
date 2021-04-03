package test2;

public class t2 {
	// 행렬의 세로 길이(행 개수) rows
	// 가로 길이(열 개수) columns
	// 회전들의 목록 queries
	// 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return
	public static int[] solution(int rows, int columns, int[][] queries) {
		
		// 숫자가 차례로 적힌 행렬
		int[][] intArr = new int[rows][columns];
		int num = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				intArr[i][j] = num;
				num++;
			}
		}
		
		// 회전
		rotation(intArr, queries[0]);
		
		
		
		int[] answer = {};
        return answer;
    }
    
	// 회전시키는 메소드
	public static int[][] rotation(int[][] arr, int[] query) {
		
		
		return arr;
	}
	
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(solution(rows, columns, queries));
	}
}
