package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChatting {
	public static String[] solution(String[] record) {
		int resultLength = 0;
		String[] msg = { "님이 들어왔습니다.", "님이 나갔습니다." };

		HashMap<String, String> hm = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		if(record.length == 1) {
			String[] result = new String[1];
			String[] str = record[0].split(" ");
			result[0] = (str[0].equals("Enter") ? str[1] + msg[0] : str[1] + msg[1]);
			return result;
		}

		for (int j = 0; j < record.length; j++) {
			String[] str = record[j].split(" ");
			if (str[0].equals("Enter")) {
				hm.put(str[1], str[2]);
				list.add(record[j]);
				resultLength++;
			} else if (str[0].equals("Leave")) {
				list.add(record[j]);
				resultLength++;
			} else if (str[0].equals("Change")) {
				hm.put(str[1], str[2]);
			} 
		}
		
		
		String[] result = new String[resultLength];
		for (int l = 0; l < list.size(); l++) {
			String tmp = hm.get(list.get(l).split(" ")[1]);
			result[l] = list.get(l).split(" ")[0].equals("Enter") ? tmp + msg[0] : tmp + msg[1];
		}
		return result;
	}

	public static void main(String[] args) {
		// 아이디, 닉네임
		String[] recode = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(solution(recode));
	}
}
