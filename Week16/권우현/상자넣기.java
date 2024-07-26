import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상자넣기 {

    //https://www.acmicpc.net/problem/1965
    //version 1 : 이중 for문
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] num = new int[n];
//        String str = br.readLine();
//        for (int i = 0; i < n; i++) {
//            num[i] = Integer.parseInt(str.split(" ")[i]);
//        }
//
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if(num[i]>num[j]){
//                    dp[i] = Math.max(dp[i], dp[j]+1);
//                }
//            }
//            ans = Math.max(ans, dp[i]);
//        }
//        System.out.println(ans);
//    }


    //version 2 : dfs

    static int[] num;
    static int[] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        dp = new int[n];
        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(str.split(" ")[i]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
        }

        System.out.println(max);
    }
    private static int dfs(int index){
        if(dp[index] != 0){
            return dp[index];
        }

        dp[index] = 1;

        for (int i = 0; i < index; i++) {
            if(num[index]>num[i]){
                dp[index] = Math.max(dp[index], dfs(i)+1);
            }
        }
        max = Math.max(dp[index], max);

        return dp[index];
    }
}