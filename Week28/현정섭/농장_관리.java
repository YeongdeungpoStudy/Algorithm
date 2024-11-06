package Week28.현정섭;
import java.io.*;
import java.util.*;

public class 농장_관리{

    public static int n;
    public static int m;
    public static boolean[][] check;
    public static int[][] mount;
    public static int answer = 0;
    
    public static class Node{
        private int a;
        private int b;

        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }

    }

    public static boolean bfs(int x, int y){
        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

        boolean[][] visited = new boolean[n][m];

        visited[x][y] = true;

        Deque<Node> deque = new ArrayDeque<>(); 

        deque.add(new Node(x, y));

        while(!deque.isEmpty()){

            Node p = deque.pollLast();

            for(int i = 0; i < 8; i++){

                int nx = p.a + dx[i];
                int ny = p.b + dy[i];

                if(nx < 0 || nx >= n || ny < 0  || ny >= m){
                    continue;
                }

                if(visited[nx][ny] == true){
                    continue;
                }

                if(mount[nx][ny] > mount[x][y]){
                    return false;
                }
                    
                if(mount[nx][ny] == mount[x][y]){
                    visited[nx][ny] = true;
                    deque.add(new Node(nx, ny));
                }

                check[nx][ny] = true; 
            }
        }
        return true;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] param = br.readLine().split(" ");
    
        n = Integer.parseInt(param[0]);
    
        m = Integer.parseInt(param[1]);
        
        check = new boolean[n][m];
        mount = new int[n][m];

        for(int i=0; i < n; i++){ 
            String[] vArray= br.readLine().split(" ");
            for(int j =0; j < m; j++){
                mount[i][j] = Integer.parseInt(vArray[j]);
            }
        }

        for(int i=0; i < n; i++){
            for(int j =0; j < m; j++){
                if(check[i][j] == false){
                    boolean peak = bfs(i,j);
                    if(peak == true){
                        System.out.println("i : " + i+ ", j : " + j);
                        answer+=1;
                    }

                }
            }
        }

        System.out.println(answer);

    
    }
}
