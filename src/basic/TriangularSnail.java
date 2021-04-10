package basic;

import java.util.ArrayList;
import java.util.List;

// 삼각 달팽이
// https://programmers.co.kr/learn/courses/30/lessons/68645?language=java
public class TriangularSnail {
	// 전체 갯수
	// 4 : 10
	// 5 : 15
	// 6 : 21
	// n : n(n+1)/2
	public static int[] solution(int n) {
		int[] answer = {};

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n * (n + 1) / 2; i++) {
			list.add(0);
		}
		System.out.println(list.size());

		// true : right
		// false : left
		boolean flag = true;
		int leftCnt = n;
		int rightCnt = 1;
		int currIdx = 0;
		int currNum = 1;
		int loopCnt = n;
		while (list.contains(0)) {
			System.out.println("flag : " + flag);
			if (flag) {
				right(list, currIdx, currNum, rightCnt, loopCnt);
				rightCnt++;
			} else {
				left(list, currIdx, currNum, leftCnt, loopCnt);
				leftCnt--;
			}
			
			if(flag) {
				flag = false;
			} else {
				flag = true;
			}
			loopCnt--;
		}

		
		
		return answer;
	}

	public static List left(List tmpList, int currIdx, int currNum, int leftCnt, int loopCnt) {
		return tmpList;
	}

	public static List right(List tmpList, int currIdx, int currNum, int rightCnt, int loopCnt) {
		for(int i = rightCnt; i < loopCnt; i++) {
//			tmpList.set(currIdx, element)
		}
		return tmpList;
	}

	public static void main(String[] args) {
		// > 1 2 3 4 ~ 연속숫자
		// < 5 4 3
		// > 2 3 ~ 연속숫자
		int n = 5; // 1,2,12,3,13,11,4,14,15,10,5,6,7,8,9

		// > 1 2 3 4 5 ~ 연속숫자
		// < 6 5 4 3
		// > 2 3 4 ~ 연속숫자
		// < 5
//		int n = 6; // 1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11
		System.out.println(solution(n));
	}
}
