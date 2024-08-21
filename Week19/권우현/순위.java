package Week19.권우현;

public class 순위 {
    class Solution {
        public int solution(int n, int[][] results) {
            int answer = 0;
            boolean[][] grade = new boolean[n][n];
            for(int i=0;i<results.length;i++){
                grade[results[i][0]-1][results[i][1]-1] = true;
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if(grade[j][i]&&grade[i][k]){
                            grade[j][k] = true;
                        }
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if(grade[i][j]||grade[j][i]) cnt++;
                }
                if(cnt==n-1) ans++;
            }


            return ans;
        }
    }

}
