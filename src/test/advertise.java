package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class advertise {
	// play_time : 총 영상 길이
	// adv_time : 공익광고 재생시간 길이
	// logs : 동영상 재생 구간 정보
	//
	// 공익광고가 들어갈 '시작 시각'을 구해서 return
	// 시청자들의 누적 재생시간이 가장 많은 곳이 여러 곳이라면, 그 중에서 가장 빠른 시작 시각을 return
	public static String solution(String play_time, String adv_time, String[] logs) {
//        List<String> list = new ArrayList<>();
		String start_time;
		String end_time;
		
		
		Arrays.sort(logs);
//        00:25:50-00:48:29
//        00:40:31-01:00:00
//        01:20:15-01:45:14
//        01:30:59-01:53:29
//        01:37:44-02:02:30
		for(int i = 0; i < logs.length; i++) {
			
		}
		
		
		
		String answer = "";
        return answer;
    }
	
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = { //
				"01:20:15-01:45:14", // -> 01:34:15
				"00:40:31-01:00:00", // -> 00:54:46
				"00:25:50-00:48:29", // -> 00:40:05
				"01:30:59-01:53:29", // -> 01:45:14
				"01:37:44-02:02:30"}; // -> 01:51:59
		// "01:30:59"
		
		System.out.println(solution(play_time, adv_time, logs));
	}
}
