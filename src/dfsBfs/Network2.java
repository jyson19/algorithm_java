package dfsBfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//네트워크
//문제 설명
//네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
//
//컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
//
//제한사항
//컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
//각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
//i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
//computer[i][i]는 항상 1입니다.
//입출력 예
//n	computers	return
//3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
//3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
public class Network2 {
	//
	// # 0 1 2
	// 0 1 1 0 {01}
	// 1 1 1 0 {10} -sort-> {01}
	// 2 0 0 1 {2}
	// connect { 01 }, { 2 } : 2
	//
	// # 0 1 2
	// 0 1 1 0
	// 1 1 1 1
	// 2 0 1 1
	// connect { 012 } : 1
	//
	// # 0 1 2 3
	// 0 1 0 0 1
	// 1 0 1 1 1
	// 2 0 1 1 0
	// 3 1 1 0 1
	// connect { 0123 } : 1
	//
	// 컴퓨터의 개수 n은 1 이상 200 이하인 자연수
	//
	// 각 컴퓨터는 0부터 n-1인 정수로 표현 -> n=3, 1대당 0~2개만큼 연결가능
	//
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		List<Integer> nList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nList.add(i);
		}
//		System.out.println(computers.length);

		boolean flag = true;
		while (flag) {
			for (int i = 0; i < n; i++) {
				HashMap<Integer, Integer> comHm = new HashMap<>();
				for (int j = 0; j < n; j++) {

					comHm.put(j, computers[i][j]);
					if (nList.get(j) <= 200 && computers[i][j] == 1) {
						nList.set(j, 201);
						System.out.println(nList);
					}
				}
				if (comHm.values().contains(0) == false) {
					return 1;
				}

				answer++;
				int listSum = nList.stream().mapToInt(Integer::intValue).sum();
				if (listSum == n * 201) {
					flag = false;
				}
			}
		}
		if (answer == n + 1) {
			return 1;
		}
		return answer - 1;
	}

	public static void main(String[] args) {
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }; // 2
//		int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }; // 1
		System.out.println(solution(3, computers));
	}
}
