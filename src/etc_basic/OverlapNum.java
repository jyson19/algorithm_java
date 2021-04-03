package etc_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverlapNum {
	public static List<Integer> solution(int[] arr) {
		// arr를 담는 배열
		List<Integer> list = new ArrayList<>();
		// 중복 값 담는 배열
		List<Integer> tmpList = new ArrayList<>();
		
		for(int i : arr) {
			list.add(i);
		}
		Collections.sort(list);
		for(int j = 1; j < list.size(); j++) {
			if(list.get(j - 1) == list.get(j)) {
				tmpList.add(list.get(j));
			}
		}
		
		// list내 중복 값 제거
		list.removeAll(tmpList);
		// 모든 값 중복 시 -1 리턴
		if(list.size() == 0) list.add(-1);
		return list;
	}
	public static void main(String[] args) {
//		int[] arr = {2, 1, 3, 3}; // 1, 2
//		int[] arr = {3, 4, 4, 2, 5, 2, 5, 5}; // 3
		int[] arr = {3, 5, 3, 5, 7, 5 ,7}; // -1
		
		System.out.println(solution(arr));
	}
}
