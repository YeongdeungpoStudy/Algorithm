package Week18.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 완전탐색
 */

public class 토마토 {
    static int[][] board;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        m = Integer.parseInt(str.nextToken());
        n = Integer.parseInt(str.nextToken());

        board = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(str.nextToken());
                if (board[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int day = bfs(q);

        if (chk()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs(Queue<int[]> queue) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int j = 0; j < 4; j++) {
                    int nx = 0;
                    int ny = 0;
                    if (j==0){
                        nx = x - 1;
                        ny = y;
                    }
                    else if (j==1){
                        nx = x + 1;
                        ny = y;
                    }
                    else if (j==2){
                        nx = x;
                        ny = y - 1;
                    }
                    else if (j==3){
                        nx = x;
                        ny = y + 1;
                    }

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return days;
    }

    private static boolean chk() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }
}
