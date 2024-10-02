import java.io.*;
import java.util.*;

public class Main {
	static int T, len, openIdx1, openIdx2;
	static int[][][] dp;
	static int[] todoArr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// n개의 같은 크기의 벽장들이 일렬로 붙어져 있고 벽장의 문은 n-2개만 있다.
		// 한 벽장 앞에 있는 문은 이웃 벽장 앞에 문이 없다면 즉 벽장이 열려있다면 그 벽장 앞으로 움직일 ㅅ ㅜ있다.

		// 그림은 7개의 벽장
		// 2번 5번 벽장이 열려있고 나머지 벽장은 닫혀 있다.
		// 벽장 문은 좌우 어느쪽이든
		// 1번 벽장을 닫고 있는 벽장문을 오른쪽으로 한 칸 이동함으로써 1번 벽장을 사용할 수 있다.
		// 이때 2번 벽장은 닫혀져 사용할 수 없다.

		T = Integer.parseInt(br.readLine());

		// boolean[] openClosets = new boolean[T+1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 열려있는 벽장 개수는 항상 2개
		openIdx1 = Integer.parseInt(st.nextToken());
		openIdx2 = Integer.parseInt(st.nextToken());

		len = Integer.parseInt(br.readLine());

		todoArr = new int[len];
		dp = new int[len][T+1][T+1];

		for (int i = 0; i < len; i++) {
			todoArr[i] = Integer.parseInt(br.readLine());
		}

		// 1 2 3 4 5 6 7
		// x o x x o x x
		// o x x x o x x
		// 3 1 6 5
		// 3

		for (int i = 0; i < len; i++) {
			for (int j = 1; j <= T; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		bw.write(dfs(0, openIdx1, openIdx2)+"");

		br.close();
		bw.close();
	}

	static int dfs(int idx, int index1, int index2) {
		if (idx == len) {
			return 0;
		}

		if (dp[idx][index1][index2] == -1) {
			int len1 = Math.abs(index1 - todoArr[idx]) + dfs(idx+1, todoArr[idx], index2);
			int len2 = Math.abs(index2 - todoArr[idx]) + dfs(idx+1, index1, todoArr[idx]);

			dp[idx][index1][index2] = Math.min(len1, len2);
		}

		return dp[idx][index1][index2];
	}
}
