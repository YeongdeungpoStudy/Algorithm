import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 상자넣기
		// 정육면체 모양의 상자가 일렬로
		// 상자마다 크기가 주어져 있는데 앞에 있는 상자의 크기가
		// 뒤에 있는 상자의 크기보다 작으면 앞에 있는 상자를 뒤에 있는 상자 안에 넣을 수 있다

		// 1,5,2,3,7인 5개의 상자가 있다면 크기 1인 상자를 크기 5인 상자에 넣고
		// 다시 이 상자를 크기 7인 상자 안에 넣을 수 있다

		// 파일의 첫 번째 줄은 상자의 개수 1 ~ 1000
		// 두 번째줄에는 각 상자의 크기가 순서대로 주어진다

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		// int[] dpCount = new int[n];
		int[] dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		// arr :  1,6,2,5,7,3,5,6

		// dp   : 1 2 2 3 4 3 4 5

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i ;j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}

		}

		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[i]);
		}

		bw.write(answer+"");

		bw.close();
	}

}