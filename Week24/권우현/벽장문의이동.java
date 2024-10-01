package Week24.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벽장문의이동 {
    static Integer[][][] dp;
    static int[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int closet = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n][closet + 1][closet + 1];
        pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp(0, Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
    }
    private static int dp(int num, int left, int right){
        if (num>= pos.length){
            return 0;
        }
        if (dp[num][left][right] != null) {
            return dp[num][left][right];
        }

        int next = pos[num];

        dp[num][left][right] = Math.min(Math.abs(next - left) + dp(num + 1, next, right), Math.abs(next - right) + dp(num + 1, left, next));

        return dp[num][left][right];
    }
}
