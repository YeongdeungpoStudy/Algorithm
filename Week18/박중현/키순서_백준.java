import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 키 순서
		// 1번부터 N 번까지 번호가 붙여져 있는 학생들에 대하여 두 학생끼리 키를 비교한 결과의 일부가 주어져있다.
		// 단 N명의 학생ㅅ들의 키는 모두 다르다고 가정한다.
		// 예를 들어, 6명의 학생들에 대하여 6번만 키를 비교하였고,
		// 그 결과가 다음과 같다고 하자.

		// 1번부터 5번보다 키가 작고, 5번은 4번보다 작기 때문에 1번은 4번 보다 작게 된다.
		// 학생들의 키를 비교한 결과가 주어졌을 때

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N+1][N+1];

		// 0 0 0 0 0 0 0
		// 0 0 0 0 0 1 0
		// 0 0 0 0 0 0 0
		// 0 0 0 0 1 0 0
		// 0 0 1 0 0 0 0
		// 0 0 0 0 1 0 0
		// 0 0 0 0 0 0 0

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int smallStudent = Integer.parseInt(st.nextToken());
			int tallStudent = Integer.parseInt(st.nextToken());

			arr[smallStudent][tallStudent] = 1;
		}

		// arr[1][4] = 1, arr[1][6] = 1, arr[1][2] = 1;
		for (int k = 1; k <=N ; k++) {
			for (int i = 1; i <= N; i++) {
				if (i==k) {
					continue;
				}
				for (int j=1; j<=N; j++) {
					if (arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}

		int answer = 0;

		for (int i = 1 ; i <= N; i++) {
			int cnt = 0;

			for (int j = 1; j <= N; j++) {

				if (arr[i][j] == 1) {
					cnt++;
				}
			}

			for (int j = 1; j <= N; j++) {

				if (arr[j][i] == 1) {
					cnt++;
				}
			}

			if (cnt == N -1) {
				answer++;
			}
		}

		bw.write(answer+"");

		bw.close();
	}

}