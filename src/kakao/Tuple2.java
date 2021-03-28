package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Tuple2 {
	public static String[] solution(String s) {
		int count = 0;
		for(String str : s.split("}")) {
			count++;
		}
		System.out.println("count : " + count);
			
		String[] answer = new String[count];

		
		List<String> list = new ArrayList<>();
		for (String str : s.replace("{", "").replace("}", "").split(",")) {
			list.add(str);
		}
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		System.out.println("--------------------------");
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < list.size(); i++) {
			int num = Integer.parseInt(list.get(i));
			if(!hm.containsKey(num)) {
				hm.put((num), 1);
			} else {
				hm.put(num, hm.get(num) + 1);
			}
		}
		
		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			
		}
		
		System.out.println(hm.get(20));
		System.out.println(hm.get(111));

		
		return answer;
	}

	public static void main(String[] args) {
//		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s = "{{123}}";
//		String s = "{{20,111},{111}}";
		System.out.println(solution(s));
	}
}
