package stackQueue;

import java.util.Collections;
import java.util.PriorityQueue;

// 이중우선순위큐
// https://programmers.co.kr/learn/courses/30/lessons/42628?language=java
public class DoublePriorityQueue {
	// 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때,
	// 모든 연산을 처리한 후 큐가 비어있으면 [0,0]
	// 비어있지 않으면 [최댓값, 최솟값]을 return
	//
	// I 숫자 큐에 주어진 숫자를 삽입합니다.
	// D 1 큐에서 최댓값을 삭제합니다.
	// D -1 큐에서 최솟값을 삭제합니다.
	public static int[] solution(String[] operations) {
		int[] answer = {};

		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < operations.length; i++) {
			// I
			if ((operations[i] + "").contains("I")) {
				minQ.add(Integer.parseInt(operations[i].substring(2)));
				maxQ.add(Integer.parseInt(operations[i].substring(2)));
				// D
			} else {
				if (!minQ.isEmpty() || !maxQ.isEmpty()) {
					// D 1
					if ((operations[i] + "").substring(2).equals("1")) {
//					maxQ.poll();
						minQ.remove(maxQ.poll());
						// D -1
					} else {
						maxQ.remove(minQ.poll());
					}
				}
			}
		}

		answer[0] = maxQ.poll();
		answer[1] = minQ.poll();

		return answer;
	}

	public static void main(String[] args) {
		String[] operations = { "I 7", "I 5", "I -5", "D -1" }; // {7, 5}
		System.out.println(solution(operations));
	}
}
