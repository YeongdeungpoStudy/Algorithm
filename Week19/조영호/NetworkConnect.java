package Week19.조영호;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.PriorityQueue;
public class NetworkConnect {
    static int[] parent;
	static PriorityQueue<info> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;
		N= Integer.parseInt(br.readLine());
		M= Integer.parseInt(br.readLine());
		
		parent= new int[N+1];
		pq= new PriorityQueue<info>();
		for(int i=1; i<=N; i++) parent[i]= i;
		
		int start, target, cost;
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			start= Integer.parseInt(st.nextToken());
			target= Integer.parseInt(st.nextToken());
			cost= Integer.parseInt(st.nextToken());
			//cost 순서로 최소힙 정렬
			pq.offer(new info(start, target, cost));
		}
		
		int answer=0, line=0;
		while(!pq.isEmpty()) {
			if(line==N-1) break;
			
			info cur= pq.poll();
			if(cur.start== cur.target) continue; //같은 컴은 연결필요X
			if(find(cur.start)!=find(cur.target)) {
				line++;
				union(cur.start, cur.target);
				answer+= cur.cost;
			}
		}
		System.out.println(answer);
	}//main
	
	//조상찾기
	static int find(int a) {
		if(parent[a]==a) return a;
		return find(parent[a]);
	}
	
	//동맹찾기
	static void union(int a, int b) {
		parent[find(a)]=find(b);
	}
	
	//노드 연결 정보
	static class info implements Comparable<info>{
		int start, target, cost;
		public info(int start, int target, int cost) {
			this.start= start;
			this.target= target;
			this.cost= cost;
		}
		@Override
		public int compareTo(info o) {
			return this.cost-o.cost;
		}
	}
}
