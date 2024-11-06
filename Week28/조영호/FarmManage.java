package Week28.조영호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FarmManage {
    static int n,m;
    static int[][] farm;
    static boolean[][] visited;
     //x,y 좌표 차이 1만큼 나는 인접한 격자 모두 비교, 시계방향
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};
    // 해당 값이 산봉우리 인지 아니인지 여부 
    static boolean top;
    //산봉우리 총갯수 
    static int count = 0;
    public static void main(String[] args) throws IOException {
        //읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //가로
        m = Integer.parseInt(st.nextToken()); //세로
        farm = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }
				//순환호출을 이용한 DFS구현
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
		            //방문되지 않고, 0이 아닌 값이면
                if(!visited[i][j] && farm[i][j] != 0){ 
                    top = true;
                    dfs(i,j);
                    if(top) count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
				//인접한 부분 모두 비교
        for(int i=0;i<8;i++){ 
            int nx = x + dx[i];
            int ny = y + dy[i];
						//조건 내 부합
            if(nx >= 0 && ny >= 0 && nx < n && ny < m){ 
                //인접한 값이 현재 값보다 더 크다면
                if(farm[x][y] < farm[nx][ny]){ 
                    //그 값은 산봉우리가 아님
                    top = false; 
                //방문하지 않았거나, 인접한 격자의 크기가 같으면
                }if(!visited[nx][ny] && farm[nx][ny] == farm[x][y]){ 
                    dfs(nx,ny);
                }
            }
        }
    }

}
