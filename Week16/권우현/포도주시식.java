import java.util.Scanner;

public class 포도주시식 {
    //https://www.acmicpc.net/problem/2156
    static Integer[] dp;
    static int[] wine;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        wine = new int[n];
        dp = new Integer[n];
        for (int i = 0; i < n; i++) {
            wine[i] = sc.nextInt();
        }
        dp[0] = wine[0];
        if (n == 2) {
            dp[1] = wine[0] + wine[1];
        } else {
            dp[1] = wine[0] + wine[1];
            dp[2] = Math.max(Math.max(wine[0] + wine[2], wine[1] + wine[2]), wine[0] + wine[1]);
        }

        System.out.println(dfs(n-1));
    }
    private static int dfs(int n){
        if(dp[n] != null){
            return dp[n];
        }

        dp[n] = Math.max(Math.max(dfs(n-3)+wine[n-1], dfs(n-2))+wine[n], dfs(n-1));

        return dp[n];
    }
}
