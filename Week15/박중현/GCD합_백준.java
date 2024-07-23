import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int k = 0; k < t; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}


			// 각 테스트 케이스마다 가능한 모든 쌍의 GCD 합을 출력
			long total = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					total += gcd(arr[i], arr[j]);
				}
			}

			bw.write(total+"\n");
		}

		bw.flush();
		bw.close();
	}

	public static long gcd(int a, int b) {
		long x = Math.max(a, b);
		long y = Math.min(a, b);

		while (x%y != 0) {
			long r = x % y;
			x = y;
			y = r;
		}

		return y;
	}
}
