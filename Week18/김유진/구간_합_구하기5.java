import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N+1][N+1];
        
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i][j-1];
            }
        }
        
        StringJoiner sj = new StringJoiner("\n");
        while(M-->0){
            int res = 0;
            st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int i = x1;i<=x2;i++){
                res+=dp[i][y2] - dp[i][y1-1];
            }
            
            sj.add(Integer.toString(res));
        }
        
        System.out.print(sj);
    }
}
