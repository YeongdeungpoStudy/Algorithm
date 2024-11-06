import java.util.*;
import java.io.*;
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Main{
    static int[][] dps = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    }; //상하좌우대각선
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] fields = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                fields[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j]){
                    continue;
                }
                boolean isTop = true;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i, j));
                visited[i][j] = true;
                while(!queue.isEmpty()){
                    Point point = queue.poll();
                    for(int[] dp:dps){
                        int newI = point.x+dp[0];
                        int newJ = point.y+dp[1];
                        if(newI <0 || newI>=N || newJ<0 || newJ>=M){
                            continue;
                        }
                        if(fields[newI][newJ] > fields[i][j]){
                            isTop = false;
                            continue;
                        }
                        if(fields[newI][newJ] < fields[i][j]){
                            continue;
                        }
                        if(visited[newI][newJ]){
                            continue;
                        }
                        visited[newI][newJ] = true;
                        queue.add(new Point(newI, newJ));
                    }
                }
                if(isTop){
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}
