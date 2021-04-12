package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 삼각 달팽이
// https://programmers.co.kr/learn/courses/30/lessons/68645?language=java
public class TriangularSnail_list {
	// 전체 갯수
	// 4 : 10
	// 5 : 15
	// 6 : 21
	// n : n(n+1)/2
	public static List<Integer> solution(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n * (n + 1) / 2; i++) {
			list.add(0);
		}

		// true : right
		// false : left
		boolean flag = true;
		int check = n;
		while (list.contains(0)) {
			if (flag) {
				right(list, check, n);
			} else {
				left(list, check);
			}
			check--;

			if (flag) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return list;
	}

	// 좌측방향
	static void left(List<Integer> tmpList, int check) {
		// 시작 인덱스
		int currIdx = tmpList.lastIndexOf(0);
		// 진행 값
		int maxInt = Collections.max(tmpList) + 1;
		for (int i = check - 1; i > 0; i--) {
			tmpList.set(currIdx, maxInt);
			maxInt++;
			currIdx = currIdx - i - 1;
			if (!tmpList.contains(0)) {
				return;
			}
		}
	}

	// 우측방향
	static void right(List<Integer> tmpList, int check, int n) {
		// 시작 인덱스
		// 두번째 바퀴 : 4
		int currIdx = tmpList.indexOf(0);
		// 진행 값
		int maxInt = Collections.max(tmpList) + 1;
		int temp = n - check + 1;
		for (int i = 0; i < check - 1; i++) {
			tmpList.set(currIdx, maxInt);
			maxInt++;
			currIdx = currIdx + i + temp;
			if (!tmpList.contains(0)) {
				return;
			}
		}
		// 연속숫자
		if (check != n) {
			check /= 2;
			currIdx = tmpList.indexOf(Collections.max(tmpList)) + 1;
		}
		for (int j = 0; j < check; j++) {
			tmpList.set(currIdx, maxInt);
			currIdx++;
			maxInt++;
			if (!tmpList.contains(0)) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		// 9부터 안돌아감..
		int n = 9;
//		int n = 1;
//		int n = 2;
//		int n = 3;
//		int n = 4; // 1,2,9,3,10,8,4,5,6,7

		// > 1 2 3 4 ~ 연속숫자
		// < 5 4 3
		// > 2 3 ~ 연속숫자
//		int n = 5; // 1,2,12,3,13,11,4,14,15,10,5,6,7,8,9

		// > 1 2 3 4 5 ~ 연속숫자
		// < 6 5 4 3
		// > 2 3 4 ~ 연속숫자
		// < 5
//		int n = 6; // 1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11
		System.out.println(solution(n));
	}
}
