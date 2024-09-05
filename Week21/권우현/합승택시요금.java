package Week21.권우현;

import java.util.Arrays;

public class 합승택시요금 {
    class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int[][] graph = new int[n+1][n+1];

            for(int i = 0;i<=n;i++){
                Arrays.fill(graph[i], 10000000);
                graph[i][i] = 0;
            }

            for (int i = 0; i < fares.length; i++) {
                int x = fares[i][0];
                int y = fares[i][1];
                int z = fares[i][2];

                graph[x][y] = z;
                graph[y][x] = z;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= n; k++) {
                        graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                    }
                }
            }

            int ans = graph[s][a] + graph[s][b];
            for (int i = 1; i <= n; i++) {
                ans = Math.min(ans, graph[s][i]+graph[i][a]+graph[i][b]);
            }

            return ans;
        }
    }
}
