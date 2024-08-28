package Week20.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애는_링크_입니다 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer str;
        int cnt = 1;
        while (true){
            n = Integer.parseInt(br.readLine());

            if (n==0) break;
            map = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                str = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str.nextToken());
                }
            }
            sb.append("Problem ").append(cnt).append(": ").append(bfs()).append("\n");
            cnt++;

        }
        System.out.println(sb);
    }

    private static int bfs(){
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,0,map[0][0]));
        visited[0][0] = true;

        while (!q.isEmpty()){
            Node tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            int cost = tmp.cost;
            System.out.println("x = " + x+" y = "+y+" cost = "+cost);

            if (x==n-1&&y==n-1){
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (nx>=0&&ny>=0&&nx<n&&ny<n&&!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny,cost+map[nx][ny]));
                }
            }
        }
        return 0;
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
}