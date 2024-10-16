package Week25.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    static String A;
    static String B;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        dp = new Integer[A.length() + 1][B.length() + 1];

        System.out.println(dp(A.length(), B.length()));
    }
    private static int dp(int i, int j){
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            dp[i][j] = dp(i - 1, j - 1) + 1;
        } else {
            dp[i][j] = Math.max(dp(i - 1, j), dp(i, j - 1));
        }

        return dp[i][j];
    }
}
