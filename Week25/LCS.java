package Week25;
import java.io.*;
import java.util.*;

public class LCS {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string1 = br.readLine();
        String string2 = br.readLine();

        int m = string1.length();
        int n = string2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=1; i <= m; i++){
            for(int j=1; j <=n; j++){
                if(string1.charAt(i-1) == string2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[m][n]);
	}

}
