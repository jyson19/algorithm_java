package dfsBfs;

import java.util.LinkedList;
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
public class MostFarNode {
	public static int solution(int n, int[][] edge){
	    boolean[] check = new boolean[n];
	    boolean[][] connect = new boolean[n][n];
	    Queue<Integer> q = new LinkedList<>();
	    for(int i=0; i<edge.length; i++){
	        connect[edge[i][0]-1][edge[i][1]-1]=true;
	        connect[edge[i][1]-1][edge[i][0]-1]=true;
	    }
	    check[0]=true;
	    q.add(0);

	    int answer = 0;
	    while(!q.isEmpty()){
	        int qSize = q.size();
	        for(int i=0; i<qSize;i++){
	            int node = q.poll();
	            for(int j=0; j<n; j++){
	                if(connect[j][node]&&!check[j]){
	                    check[j]=true;
	                    q.add(j);
	                }
	            }
	        }
	        answer=qSize;
	    }
	    return answer;
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
//		System.out.println(solution(n, edge));
		System.out.println(solution(n, edge));
	}
}
