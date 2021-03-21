package kakao;

import java.util.ArrayList;
import java.util.List;

// 문제 잘못이해해서 망한버전
public class Tuple {
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

		String tmp = "";
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list);
			answer[j] = list.get(0);
			tmp = list.get(0);
			System.out.println("tmp : " + tmp);
			System.out.println("list.get(j) : " + list.get(0));
			for (int i = list.size() - 1; i >= 0; i--) {
				if (tmp.equals(list.get(i))) {
					list.remove(tmp);
				}
			}
		}
		if(answer.length >= 2)
			answer[answer.length - 1] = list.get(0);
		System.out.println(answer[0]);
//		System.out.println(answer[1]);
//		System.out.println(answer[2]);
//		System.out.println(answer[3]);
		return answer;
	}

	public static void main(String[] args) {
//		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String s = "{{123}}";
		String s = "{{20,111},{111}}";
		System.out.println(solution(s));
	}
}
