package codingTest;

import java.util.Arrays;

public class Q3 {

	static int[] answer;
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		answer = new int[enroll.length];
		
		// String[] seller = {"young", "john", "tod", "emily", "mary"};
		for(int i = 0; i < seller.length; i++) {
			find_enroll(seller[i], enroll, referral, amount[i]*100.0);
		}
		
		// mary 108, edward 108, jaimie 18
		Arrays.stream(answer).forEach(System.out::println);
		
		return answer;
	}
	
	// 등록 명부 찾기
	public static void find_enroll(String name, String[] enroll, String[] referral, double amount) {
		for(int i = 0; i < enroll.length; i++) {
			if(enroll[i].equals(name)) {
				answer[i] += Math.ceil(amount*0.9);
				amount = (int) (amount*0.1);
				find_enroll(find_referral(i, referral), enroll, referral,amount);
			}
		}
	}
	
	// 추천인 찾기
	public static String find_referral(int index, String[] referral) {
		return referral[index];
	}

	// 실행 메소드
	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		// [360, 958, 108, 0, 450, 18, 180, 1080]
		
		String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller1 = {"sam", "emily", "jaimie", "edward"};
		int[] amount1 = {2, 3, 5, 4};
		// {0, 110, 378, 180, 270, 450, 0, 0}
		
		String[] enroll2 = {"john", "mary", "sam", "edward", "sam", "emily"};
		String[] referral2 = {"-", "-", "-", "-", "sam", "mary"};
		String[] seller2 = {"john", "mary", "sam"};
		int[] amount2 = {2, 3, 4};

		System.out.println(solution(enroll, referral, seller, amount));
	}

}
