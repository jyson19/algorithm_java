package greedy;

public class Joystick3 {

	public static int solution(String name) {

		int len = name.length();
		int min_move = len - 1;
		// 처음부터 끝까지 오른쪽으로 갈 때의 이동횟수

		int answer = 0;

		for (int i = 0; i < len; ++i) {
			// 1. 상하: A로 가는 가까운 길
			// a ... l 'm' n ... z
			if (name.charAt(i) <= 'M') {
				answer += name.charAt(i) - 'A';
			} else {
				answer += 'Z' - name.charAt(i) + 1;
			}

			// 2. 좌우: 연속된 A의 등장에 따라 달라지는 최소 움직임
			int next = i + 1;
			while (next < len && name.charAt(next) == 'A') {
				++next;
			}
			min_move = Math.min(min_move, i + len - next + Math.min(i, len - next));

		}
		return answer += min_move;
	}

	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
		System.out.println(solution("AABAAAAAAABBB")); // 답 : 11 -- 16 : 15, ABBBAAAAAAABA
	}
}
