package bruteForce;

import java.util.Arrays;
import java.util.stream.IntStream;

// 동영상 재생시간 길이 play_time
// 공익광고의 재생시간 길이 adv_time
// 시청자들이 해당 동영상을 재생했던 구간 정보 logs
public class AdvertiseInsertion {

	public static int timeSec(String time) {
		String[] timeArr = time.split(":");
		int timeToSec = 0;
		timeToSec += Integer.parseInt(timeArr[0]) * 3600;
		timeToSec += Integer.parseInt(timeArr[1]) * 60;
		timeToSec += Integer.parseInt(timeArr[2]);
		return timeToSec;
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		int playTime = timeSec(play_time), advTime = timeSec(adv_time);

		Arrays.sort(logs);

//		System.out.println(logs[0]);
//		System.out.println(logs[logs.length - 1]);
		
//		int startTime = timeSec(logs[0].split("-")[0]) - 1;
//		int endTime = timeSec(logs[logs.length - 1].split("-")[1]) - 1;
		
//		System.out.println("startTime : " + startTime);
//		System.out.println("endTime : " + endTime);
		
		int[] timeArr = new int[360000];
		for(String log : logs) {
			int st = timeSec(log.split("-")[0]) - 1;
			int et = timeSec(log.split("-")[1]) - 1; 
			System.out.println("st : " + st);
			System.out.println("et : " + et);
			
			for(int i = st; i < et; i++) {
				timeArr[i] += 1;
			}
		}
		System.out.println(timeArr);
		
		

		return answer;
	}

	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
				"01:37:44-02:02:30" };
		System.out.println(solution(play_time, adv_time, logs));
	}
}
