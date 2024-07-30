import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 홀수인 자연수 N

		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		// 0,0 0,1 0,2 0,3 0,4
		// 1,0 1,1 1,2 1,3 1,4
		// 2,0 2,1 2,2 2,3 2,4
		// 3,0 3,1 3,2 3,3 3,4
		// 4,0 4,1 4,2 4,3 4,4

		int lastNum = N*N;

		int start = 0; // 0
		int end = N - 1; // 4

		while (start != end) {

			// 아래쪽 먼저 채우기
			for (int i = start; i < end; i++) {
				arr[i][start] = lastNum;
				lastNum--;
			}

			// 오른쪽 채우기
			for (int i = start; i < end; i++) {
				arr[end][i] = lastNum;
				lastNum--;
			}

			// 위쪽 채우기
			for (int i = end; i > start; i--) {
				arr[i][end] = lastNum;
				lastNum--;
			}

			// 왼쪽 채우기
			for (int i = end; i > start; i--) {
				arr[start][i] = lastNum;
				lastNum--;
			}

			start++;
			end--;
		}

		arr[start][end] = lastNum;

		int x = -1;
		int y = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == target) {
					x = i+1;
					y = j+1;
				}
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}

		bw.write(x + " " + y);

		bw.flush();
		bw.close();
	}

}
