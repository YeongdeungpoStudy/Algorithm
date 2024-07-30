import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 포도주 시식
		// 다양한 포도주 일렬로
		// 포도주 시식
		// 연속으로 놓여있는 3잔을 모두 마실 수는 없다

		// 6 10 13 9 8 1

		// dp[3] = arr[0]+arr[1]+arr[3] || arr[0] + arr[2]+arr[3]
		//        == dp[1] + arr[3] || dp[0] + arr[2] + arr[3]
		//       +++++ dp[2]가 제일 클 수도 -> 이거 고려

		// dp[4] =>  dp[2] + arr[4] || dp[1] + arr[3] + arr[4]


		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) { // n ==1 일때는 무조건 첫 번째 포도주
			bw.write(arr[0]+"");
		} else if (n == 2) { // n==2일 때는 첫 번째 포도주 + 두 번째 포도주
			bw.write(arr[0]+arr[1]+"");
		} else if (n == 3) { // n == 3일때는 경우의 수 발생
			bw.write(Math.max(Math.max(arr[0]+arr[1], arr[0] + arr[2]), arr[1] + arr[2])+"");
		} else { // n==4일때 부터 본격적인 dp 진행
			dp[0] = arr[0];
			dp[1] = arr[0] + arr[1];
			dp[2] = Math.max(Math.max(arr[0]+arr[1], arr[0] + arr[2]), arr[1] + arr[2]);

			for (int i = 3; i < n; i++) {
				dp[i] = Math.max(Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]), dp[i-1]);
			}

			Arrays.sort(dp);

			bw.write(dp[n-1] + "");
		}

		bw.close();
	}

}