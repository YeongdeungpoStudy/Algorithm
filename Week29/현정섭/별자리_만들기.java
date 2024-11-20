package Week29.현정섭;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 별자리_만들기{

    public static class Node{

        int a, b;
        double c;

        public Node(int a, int b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

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
        
        int n = Integer.parseInt(br.readLine()); 

        double[][] loc = new double[n][2];

        ArrayList<Node> costs = new ArrayList<>();

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double u = Double.parseDouble(st.nextToken());
			double v = Double.parseDouble(st.nextToken());
			loc[i] = new double[]{u, v};
        }

        for(int i = 0; i<n; i++){
            
            for(int j = i; j<n; j++){
                double c1 = Math.pow(loc[i][0] - loc[j][0],2);
                double c2 = Math.pow(loc[i][1] - loc[j][1],2);
                double c3 = Math.sqrt(c1 + c2);
                costs.add(new Node(i,j,c3));
                
            }
        }

        parent = new int[n+1];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        costs.sort(Comparator.comparingDouble(node -> node.c));
        
        double answer = 0;
        int edges = 0;

        for(Node edge : costs){
            if(edges == n-1){
                break;
            }

            if((find(edge.a) != find(edge.b))){

                union(edge.a, edge.b);
                
                answer += edge.c;
                
                edges++;
                
            }
            
        }

        System.out.println(String.format("%.2f", answer));
        
    }
}