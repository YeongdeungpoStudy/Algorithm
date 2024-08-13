import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키_순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        boolean [][] graph = new boolean[n+1][n+1];
        int[] cnt = new int[n+1];

        int small;
        int tall;

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            small = Integer.parseInt(stringTokenizer.nextToken());
            tall = Integer.parseInt(stringTokenizer.nextToken());

            graph[small][tall] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(graph[j][i]&&graph[i][k]){
                        graph[j][k] = true;
                    }
                }
            }
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j]||graph[j][i]){
                    cnt[i]++;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n + 1; i++) {
            if(cnt[i]==n-1){
                ans++;
            }
        }

        System.out.println(ans);

    }
}
