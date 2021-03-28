package dp;

import java.util.Arrays;

public class Sticker {

	public static int solution(int[] sticker) {

		int sLen = sticker.length;

		int[] dp1 = new int[sLen];
		int[] dp2 = new int[sLen];

		
		if(sLen <= 3) {
			return Arrays.stream(sticker).max().getAsInt();
		}
		
		// dp1[1] = s[0] 
		// 0번인덱스부터 조회 ~ 마지막값 제외
		dp1[0] = sticker[0];
		dp1[1] = sticker[1];
		dp1[2] = sticker[2] + dp1[0];
		
		// dp2[1]=s[1]
		// dp[i] = sticker[i] + Math.max(dp[i - 2], dp[i - 3]);
		// 1번인덱스부터 조회 ~ 마지막값까지
		dp2[0] = 0;
		dp2[1] = sticker[1];
		dp2[2] = sticker[2] + dp2[0];
		
		
		// 3456
		for (int i = 3; i < sLen; i++) {
			if(!(i == sLen - 1)) {
				dp1[i] = sticker[i] + Math.max(dp1[i - 2], dp1[i - 3]);
			}
			dp2[i] = sticker[i] + Math.max(dp2[i - 2], dp2[i - 3]);
		}
		
		// 최대값 지정
		int i = sLen;
		int dp1Max = Math.max(dp1[i - 3], dp1[i - 2]);
		int dp2Max = Math.max(dp2[i - 2], dp2[i - 1]);

		return Math.max(dp1Max, dp2Max);
	}

	public static void main(String[] args) {
		int sticker[] = { 1, 2, 15, 4, 7, 8, 3, 10 }; // 33
//		int sticker[] = { 14, 6, 5, 11, 3, 9, 2, 10 }; // 36
//		int sticker[] = { 1, 3, 2, 5, 4 }; // 8
		System.out.println(solution(sticker));
	}
}
