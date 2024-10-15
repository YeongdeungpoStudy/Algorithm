package Week25;
import java.io.*;
import java.util.*;

public class 이동하기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i < n+1; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 1; j < m+1; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                dp[i][j] = Math.max(map[i][j] + dp[i-1][j], map[i][j] + dp[i][j-1]);
            }
        }
        
        System.out.println(dp[n][m]);

	}

}
