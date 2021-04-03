package test;

import java.util.ArrayList;
import java.util.List;

public class Kakao2 {
	// 로봇 한 대는 부품 한 종류만 처리할 수 있으며
	// 완제품의 종류에 따라 필요한 부품이 다를 수 있습니다
	// 
	// 완제품을 만드는 데 필요한 부품의 정보 needs
	// 최대로 구매 가능한 로봇 수 r
	// 최대 몇 종류의 완제품을 만들 수 있는지 return
	public static int solution(int[][] needs, int r) {
		// needs[0].length
		// 완제품의 개수 : needs.length
		
		
		
		// r대로 가능한 조합
		// needs[0].length 개 중에서 r개 선택 경우의 수
		int[] makeRobo = new int[3];
		for(int i = 0; i < needs[0].length; i++) {
			for(int j = 0; j < r; j++) {

			}
		}
		
		System.out.println(needs[0][0]);
		System.out.println(needs[0][1]);
		System.out.println(needs[0][2]);
		
		
		
		
		
		
        int answer = 0;
        return answer;
    }
	public static void main(String[] args) {
		int[][] needs = {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
		int r = 2;
		System.out.println(solution(needs, r));
	}
}
