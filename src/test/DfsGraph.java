package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DfsGraph {
	// 전체 역의 개수 n
	//		n은 2 이상 100,000 이하인 자연수
	//
	// 1번부터 n번 역까지 일일 이용객 수 passenger
	//		passenger의 길이는 n
	//
	// 역 사이의 철로 연결 정보 train
	//		train의 세로(행) 길이는 n - 1
	//		train의 가로(열) 길이는 2
	//
	// 종착역으로 지정할 역 번호와 그때의 이용객 수 합을 순서대로 배열에 담아 return
	
	
	// 출발역은 1번 역
	static int Ne; // 간선 개수
	static int Nv; // 정점(노드) 개수
	static ArrayList<ArrayList<Integer>> ad; //인접 리스트
	static boolean[] visit; // 정점(노드) 방문 여부 확인 용도

	public static void bfs(int i, int Nv){
	    Queue <Integer>q = new <Integer> LinkedList();
	    // hash Map을 이용하여 queue data 중복 방지
	    HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
	    
	    // add는 큐가 꽉차면 예외 발생, 
	    // offer는 추가에 실패를 의미하는 false return
	    q.offer(i);
	    
	    //q가 빌때 까지 실행
	    while(!q.isEmpty()){
	        // 방문할 노드를 큐에서 값 빼기, 
	        // remove는 큐에 데이터가 없으면 예외발생, 
	        // poll은 데이터가 없으면 실패를 의미하는 false return
	        int temp = q.poll();
	        // 해당 노드를 방문 처리
	        visit[temp] = true;
	        // 방문 노드 출력
	        System.out.print(temp);
	        
	        // arraylist에서 방문할 노드에서 인접한 노드들 arraylist 값 하나 하나 출력
	        for(int j : ad.get(temp)){
	            // 인접 노드에 방문하지 않았고, 중복된 데이터를 입력한 적 없으면
	            if(visit[j] == false && !hash.containsKey(j)){
	                // 다음 방문 노드로 큐에 넣기
	                q.offer(j);
	                // hash에 j 방문 정보 입력
	                hash.put(j, true);
	            }
	        }
	    }
	}

//	public static void main(String[] args) {
//	    Nv = 8;
//	    Ne = 6;
//	    ad = new <ArrayList<Integer>> ArrayList(Nv+1);
//	    visit = new boolean[Nv+1];
//	    
//	    for(int i = 0; i <= Nv+1; i++){
//	        ad.add(new ArrayList());
//	    }
//
//	    put(1,5);
//	    put(1,6);
//	    put(2,3);
//	    put(2,4);
//	    put(2,6);
//	    put(3,4);
//	    put(3,5);
//	    put(5,6);
//	    
//	    bfs(1);        
//	}

	    // 그래프 추가 (양방향)
	public static void put(int x, int y) {
	    ad.get(x).add(y);
	    ad.get(y).add(x);
	}
	public static int[] solution(int n, int[] passenger, int[][] train) {
		
		
		
		
		
        int[] answer = {};
//        static int Ne; // 간선 개수
//    	static int Nv; // 정점(노드) 개수
//	    Nv = 8;
//	    Ne = 6;
	    ad = new <ArrayList<Integer>> ArrayList(train.length+1);
	    visit = new boolean[train.length+1];
	    
	    for(int i = 0; i <= train.length - 1; i++){
	        ad.add(new ArrayList());
	    }
        
        for(int i = 0; i < train.length; i++) {
        	put(train[i][0], train[i][1]);
        }
        bfs(1, train.length);
        
        
        return answer;
    }
	public static void main(String[] args) {
		int n = 6;
		int[] passenger = {1,1,1,1,1,1};
		int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
		System.out.println(solution(n, passenger, train));
	}
}
