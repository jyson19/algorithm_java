package dfsBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 가장 먼 노드
// https://programmers.co.kr/learn/courses/30/lessons/49189
//
// 노드의 개수 n
// 간선에 대한 정보가 담긴 2차원 배열 vertex
// 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return
//
// 노드의 개수 n은 2 이상 20,000 이하입니다.
// 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
// vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
public class MostFarNode_fail {
	static int[][] map;
	static boolean[] visited;
	static int N, M, start, end;

	public static int solution(int n, int[][] edge) {
		int max = 0;
		int answer = 0;
		for (int i = 0; i < edge.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (edge[i][j] >= max)
					max = edge[i][j];
			}
		}

		N = max;
		M = edge.length;

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < edge.length; i++) {
			for (int j = 0; j < 2; j++) {
				map[edge[i][0]][edge[i][1]] = 1;
				map[edge[i][1]][edge[i][0]] = 1;
			}
		}

		List<Integer> list = new ArrayList<>();
		list.add(0);
		bfs(1, list);
		answer = list.get(0);
		return answer;
	}

	static void bfs(int point, List<Integer> list) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(point);
		visited[point] = true;

		while (!queue.isEmpty()) {
			if (queue.size() >= list.get(0))
				list.set(0, queue.size());
			int x = queue.poll();
			System.out.println(x + " 체크");
			for (int i = 1; i <= N; i++) {
				// 연결되있고, 미방문 시
				if (map[x][i] == 1 && visited[i] == false) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
//		System.out.println(solution(n, edge));
		System.out.println(solution(n, edge));
	}
}
