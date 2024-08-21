package Week19.권우현;

public class 순위 {
    static class Solution {
        public int solution(int n, int[][] results) {
            int[][] grade = new int[n][n];

            for(int i = 0; i < results.length; i++){
                grade[results[i][0] - 1][results[i][1] - 1] = -1;
                grade[results[i][1] - 1][results[i][0] - 1] = 1;
            }



                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            if (grade[j][i] == -1 && grade[i][k] == -1) {
                                grade[j][k] = -1;
                                grade[k][j] = 1;
                            }
                            if (grade[j][i] == 1 && grade[i][k] == 1) {
                                grade[j][k] = 1;
                                grade[k][j] = -1;
                            }
                        }
                    }
                }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (grade[i][j] != 0) {
                        cnt++;
                    }
                }
                if (cnt == n - 1) {
                    ans++;
                }
            }

            return ans;
        }
    }

}
