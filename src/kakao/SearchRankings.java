package kakao;

import java.util.ArrayList;
import java.util.List;

// 5만 * 10만개 데이터 탐색에 비효율적
public class SearchRankings {
	public static int[] solution(String[] info, String[] query) {
		
		int[] answer = new int[info.length];

		List<String> infoList = new ArrayList<>();
		for (String str1 : info) {
			infoList.add(str1);
		}

		List<String> queryList = new ArrayList<>();
		for (String str2 : query) {
			queryList.add(str2);
		}
		
		for (int i = 0; i < queryList.size(); i++) {
			int ansCnt = 0;
			List<String> qList = new ArrayList<>();
			for (String qs : queryList.get(i).replace(" and", "").split(" ")) {
				qList.add(qs);
			}
			for (int h = 0; h < 5; h++) {
				int cnt = 0;
				List<String> iList = new ArrayList<>();
				for (String is : infoList.get(h).split(" ")) {
					iList.add(is);
				}
				if(Integer.parseInt(iList.get(4)) >= Integer.parseInt(qList.get(4))) {
					cnt++;
				}
				for(int l = 0; l < qList.size() - 1; l++) {
					if (iList.get(l).equals(qList.get(l)) || qList.get(l).equals("-")) {
						cnt++;
					} else break;
				}
				if (cnt == 5) {
					ansCnt++;
				}
			}
			answer[i] = ansCnt;
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
		System.out.println(answer[3]);
		System.out.println(answer[4]);
		System.out.println(answer[5]);
		return answer;
	}

	public static void main(String[] args) {
		String[] info = { //
				"java backend junior pizza 150", //
				"python frontend senior chicken 210", //
				"python frontend senior chicken 150", //
				"cpp backend senior pizza 260", //
				"java backend junior chicken 80", //
				"python backend senior chicken 50" };
		String[] query = { //
				"java and backend and junior and pizza 100", //
				"python and frontend and senior and chicken 200", //
				"cpp and - and senior and pizza 250", //
				"- and backend and senior and - 150", //
				"- and - and - and chicken 100", //
				"- and - and - and - 150" };
		System.out.println(solution(info, query)); // [1,1,1,1,2,4]
//		solution(info, query); // [1,1,1,1,2,4]
	}
}
