import java.util.*;
import java.io.*;

class Line implements Comparable<Line>{
    int end;
    int cost;
    
    public Line(int end, int cost){
        this.end=end;
        this.cost=cost;
    }
    
    public int compareTo(Line line){
        return Integer.compare(this.cost, line.cost);
    }
}

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[][] roads = new int[N+1][N+1];
        
        StringTokenizer st;
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            roads[a][b]=c;
            roads[b][a]=c;
        }
        
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Line> queue = new PriorityQueue<>();
        queue.add(new Line(1, 0));
        int result = 0;
        
        while(!queue.isEmpty()){
            Line line = queue.poll();
            
            if(visited[line.end]){
                continue;
            }
            visited[line.end]=true;
            result+=line.cost;
            
            for(int i=1;i<=N;i++){                
                if(visited[i]){
                    continue;
                }
                
                if(roads[line.end][i] == 0){
                    continue;
                }
                
                queue.add(new Line(i, roads[line.end][i]));
            }
        }
        
        System.out.print(result);
    }
}
