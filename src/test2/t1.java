package test2;

import java.util.ArrayList;
import java.util.List;

public class t1 {
	// 구매한 로또 번호를 담은 배열 lottos
	// 당첨 번호를 담은 배열 win_nums
	// 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        
        List<Integer> lList = new ArrayList<>();
        List<Integer> wList = new ArrayList<>();
        
        for(int i = 0; i < 6; i++) {
        	lList.add(lottos[i]);
        	wList.add(win_nums[i]);
        }
        
        int cnt = 0;
        int zeroCnt = 0;
        for(int j = 0; j < 6; j++) {
        	if(lList.get(j) == 0) zeroCnt++;
        	for(int k = 0; k < 6; k++) {
        		if(lList.get(j) == wList.get(k) && lList.get(j) != 46) {
        			lList.set(j, 46);
        			wList.set(k, 46);
        			cnt++;
        		}
        	}
        }

        if(cnt != 0) {
        	answer[0] = 7 - (cnt+zeroCnt);
        	answer[1] = 7 - cnt;
        } else {
        	answer[0] = 1;
        	answer[1] = 6;
        }
        if(cnt+zeroCnt < 2)	
        	answer[1] = 6;
        	
//        answer[0] = 6;
        
        
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }
	public static void main(String[] args) {
//		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] lottos = {1, 2, 3, 4, 5, 6};
//		int[] lottos = {0, 0, 0, 0, 0, 0};
//		int[] win_nums = {31, 10, 45, 1, 6, 19};
//		int[] win_nums = {38, 19, 20, 40, 15, 25};
		int[] win_nums = {7, 8, 20, 40, 15, 25};
		System.out.println(solution(lottos, win_nums));
	}
}
