import java.util.*;
import java.io.*;

class Road implements Comparable<Road>{
    int end;
    int cost;
    
    public Road(int end, int cost){
        this.end=end;
        this.cost=cost;
    }
    
    public int compareTo(Road road){
        return Integer.compare(this.cost, road.cost);
    }
}

public class Main{
    static int N;
    static int[][] roads;
    static int[][] dist;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        roads = new int[N+1][N+1];
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(b==0){
                roads[u][v]=1;
            } else{
                roads[u][v] = 2;
                roads[v][u] = 2;
            }
        }
        
        //dijkstra
        dist = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
            dijkstra(i);
        }
        
        
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        StringJoiner sj = new StringJoiner("\n");
        while(K-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            sj.add(Integer.toString(dist[s][e]));
        }
        
        System.out.print(sj);
    }
    
    static void dijkstra(int n){
        PriorityQueue<Road> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        queue.add(new Road(n, 0));
        
        while(!queue.isEmpty()){
            Road road = queue.poll();
            
            if(visited[road.end]){
                continue;
            }
            visited[road.end] = true;
            
            for(int i=1;i<=N;i++){
                if(visited[i]){
                    continue;
                }
                
                if(roads[road.end][i] == 0 && roads[i][road.end]==0){
                    continue;
                }
                
                int newCost;
                if(roads[road.end][i]>0){
                    newCost = road.cost;
                } else {
                    newCost = road.cost+1;
                }
                
                if(dist[n][i] > newCost){
                    dist[n][i] = newCost;
                    queue.add(new Road(i, newCost));
                }
            }
        }
    }
}
