package Week25.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이동하기 {
    static int n;
    static int m;
    static int[][] map;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        String[] split = tmp.split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        map = new int[n][m];
        dp = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            tmp = br.readLine();
            split = tmp.split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        dp[0][0] = map[0][0];
        System.out.println(dp(n - 1, m - 1));
    }
    private static int dp(int r, int c) {
        if (r < 0 || c < 0) {
            return 0;
        }

        if (dp[r][c] != null) {
            return dp[r][c];
        }

        dp[r][c] = Math.max(dp(r - 1, c), dp(r, c - 1)) + map[r][c];

        return dp[r][c];
    }
}
