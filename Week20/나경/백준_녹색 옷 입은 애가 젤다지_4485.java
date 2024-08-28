import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        int[] dy = {0, 1, 0, -1}; // 우하좌상
        int[] dx = {1, 0, -1, 0}; // 우하좌상
        int test_case = 1;

        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            if (N == 0)
                break;

            int[][] map = new int[N][N];
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
                return Integer.compare(o1[2], o2[2]);
            });

            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            pq.offer(new int[]{0, 0, map[0][0]});
            dist[0][0] = map[0][0]; // 첫번째 위치 초기화

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int y = cur[0];
                int x = cur[1];
                int cost = cur[2];

                if (dist[y][x] < cost) {
                    continue;
                }

                if (y == N - 1 && x == N - 1)
                    break;

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) // 범위를 벗어나면 건너 뜀
                        continue;

                    if (dist[ny][nx] > dist[y][x] + map[ny][nx]) {
                        dist[ny][nx] = dist[y][x] + map[ny][nx]; // 현재 위치에서 ny, nx로 이동하는 비용으로 업데이트
                        pq.offer(new int[]{ny, nx, dist[ny][nx]}); // 업데이트한 정보를 큐에 넣어준다
                    }
                }

            }

            sb.append("Problem ").append(test_case++).append(':').append(' ').append(dist[N - 1][N - 1]).append('\n');

        }

        System.out.print(sb);
    }
}