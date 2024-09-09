package Week22.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long [][] dp = new long[n][21];

        String[] num = br.readLine().split(" ");
        dp[0][Integer.parseInt(num[0])] = 1;

        for (int i = 1; i < n-1; i++) {
            int now = Integer.parseInt(num[i]);
            for (int j = 0; j < 21; j++) {
                if (dp[i-1][j] != 0){
                    if (j+now<=20){
                        dp[i][j+now] += dp[i-1][j];
                    }
                    if (j-now>=0){
                        dp[i][j-now] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][Integer.parseInt(num[n-1])]);
    }
}
