import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문제
		// N * N 개의 수가 N * N 크기의 표에 채워져있다.

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1  2  3  4
		// 2  3  4  5
		// 3  4  5  6
		// 4  5  6  7

		// 1  3  6  10
		// 3  8  15 24   8 = 3(북)+3(서)-1(북서)+3(자기)
		//               15 = 6(북)+8(서)-3(북서)+4(자기)
		//               24 = 10(북)+15(서)-6(북서)+5(자기)

		// 1  3  6  10
		// 2  5  9  14

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0) {
					if (j == 0) {
						dp[0][0] = arr[0][0];
						continue;
					}
					dp[i][j] = dp[i][j-1] + arr[i][j];

				} else if (j==0) {
					dp[i][j] = dp[i-1][j] + arr[i][j];

				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			int answer = 0;

			if (x1 == 0 && y1 == 0) {
				answer = dp[x2][y2];
			} else if (x1 == 0) {
				// x2 = 2 y2 =2, x1=0 y1=2
				answer = dp[x2][y2] - dp[x2][y1-1];
			} else if (y1 == 0) {
				answer = dp[x2][y2] - dp[x1-1][y1];
			} else {
				answer = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
			}

			sb.append(answer + "\n");

		}

		bw.write(sb.toString());

		bw.close();
	}

}