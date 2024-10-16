import java.util.*;
import java.io.*;

public class Main{
    static int[][] dp;
    static int[][] fields;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sizes = br.readLine().split(" ");

        int N = Integer.parseInt(sizes[0]);
        int M = Integer.parseInt(sizes[1]);

        dp = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(dp[i], -1);
        }

        fields = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            String[] row = br.readLine().split(" ");
            for(int j=1;j<=M;j++){
                fields[i][j] = Integer.parseInt(row[j-1]);
            }
        }

        int result = calculate(N, M);

        System.out.print(result);
    }

    static int calculate(int n, int m){
        if(n == 0 || m== 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        int result = Math.max(calculate(n-1, m),calculate(n, m-1))+fields[n][m];
        dp[n][m] = result;

        return result;
    }
}
