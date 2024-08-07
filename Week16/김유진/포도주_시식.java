import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wine[1];

        if(N >= 2) {
            dp[2] = wine[1] + wine[2];
        }

        for(int i=3;i<=N;i++){
            dp[i] = Math.max(Math.max(wine[i-1]+dp[i-3]+wine[i], dp[i-2]+wine[i]), dp[i-1]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=N;i>=1;i--){
            if(max < dp[i]){
                max = dp[i];
            }
        }

        System.out.print(max);
    }
}
