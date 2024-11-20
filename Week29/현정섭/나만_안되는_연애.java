package Week29.현정섭;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나만_안되는_연애{
    private static int[] parent;
    
    private static int find(int x){
        if(parent[x] == x){
            return x;
        }
        
        return find(parent[x]);
    }
    
    private static void union(int x, int y){
        int root1 = find(x);
        int root2 = find(y);
        
        if(root1 < root2){
            parent[root2] = root1;    
        }
        else{
            parent[root1] = root2;
        }
        
    }

    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        String[] param1 = br.readLine().split(" ");

        int n = Integer.parseInt(param1[0]);
        int m = Integer.parseInt(param1[1]); 

        String[] param2 = br.readLine().split(" ");

        int[][] costs = new int[m][3];

        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			costs[i] = new int[]{u, v, d};
        }

        parent = new int[n+1];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        int answer = 0;
        int edges = 0;
        for(int[] edge : costs){
            if(edges == n-1){
                break;
            }

            if((find(edge[0]) != find(edge[1])) && !(param2[edge[0]-1].equals(param2[edge[1]-1]))){

                union(edge[0], edge[1]);
                
                answer += edge[2];
                
                edges++;
                
            }
            
        }

        if(edges == n-1){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
        
    }
}