package test;

import java.util.ArrayList;
import java.util.List;

public class Kakao1 {
	// 사람들이 가지고 있는 상품권에 적힌 번호가 순서대로 들어있는 배열 gift_cards
	// 각 사람이 받고 싶어 하는 상품 번호가 순서대로 들어있는 배열 wants
	// 원하는 상품을 받지 못하는 사람의 최솟값을 return
	public static int solution(int[] gift_cards, int[] wants) {

		int answer = 0;
		List<Integer> gList = new ArrayList<>();
		List<Integer> wList = new ArrayList<>();

		for (int i : gift_cards) {
			gList.add(i);
		}
		for (int j : wants) {
			wList.add(j);
		}

		for (int k = 0; k < gift_cards.length; k++) {
			for (int l = 0; l < gift_cards.length; l++) {
				if (gList.get(k) == wList.get(l)) {
					if (gList.get(k) != 0) {
						gList.set(k, 0);
						wList.set(l, 0);
					}
				}
			}
		}
		for(int m = 0; m < gList.size(); m++) {
			if(gList.get(m) != 0) answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] gift_cards = { 4, 5, 3, 2, 1 };
		int[] wants = { 2, 4, 4, 5, 1 };
		System.out.println(solution(gift_cards, wants));
	}
}
