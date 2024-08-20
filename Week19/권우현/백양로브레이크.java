package Week19.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백양로브레이크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(str.nextToken());

        int[][] board = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = 100000000;
                if (i==j){
                    board[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            if (b==1){
                board[u][v] = 0;
                board[v][u] = 0;
            }
            else{
                board[u][v] = 0;
                board[v][u] = 1;
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    board[j][k] = Math.min(board[j][k], board[j][i] + board[i][k]);
                }
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            str = new StringTokenizer(br.readLine());
            System.out.println(board[Integer.parseInt(str.nextToken())][Integer.parseInt(str.nextToken())]);
        }
    }
}
