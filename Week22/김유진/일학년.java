import java.util.*;
import java.io.*;

class Main{
    static int MAX = 20;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N][MAX+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        dp[0][start]++;
        for(int i=1;i<N-1;i++){
            int now = Integer.parseInt(st.nextToken());

            for(int prev = 0;prev<=MAX;prev++){
                if(dp[i-1][prev] == 0){
                    continue;
                }

                int plus = prev + now;
                int minus = prev - now;

                if(plus >= 0 && plus<=MAX){
                    dp[i][plus] += dp[i-1][prev];
                }

                if(minus >= 0 && minus<=MAX){
                    dp[i][minus] += dp[i-1][prev];
                }
            }
        }

        int result = Integer.parseInt(st.nextToken());

        System.out.print(dp[N-2][result]);
    }
}
