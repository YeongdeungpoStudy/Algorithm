import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 2차원 세계에 블록이 쌓여있다. 비가 오면 블록 사이에 빗물이 고인다.
		// 비는 충분히 많이 온다. 고이는 빗물의 총량은?

		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] arr = new int[w];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;

		for (int i = 1; i < w-1; i++) {
			int leftMaxHeight = 0;
			int rightMaxHeight = 0;
			// 각각의 인덱스를 기준으로 생각해보자
			// index: 1 기준으로 왼쪽 / 오른쪽에 큰 값이 있어야 빗물이 고임

			// 왼쪽 찾기
			for (int j = 0; j < i; j++) {
				leftMaxHeight = Math.max(arr[j], leftMaxHeight);
			}

			for (int j = i + 1; j < w; j++) {
				rightMaxHeight = Math.max(arr[j], rightMaxHeight);
			}

			if (arr[i] < leftMaxHeight && arr[i] < rightMaxHeight) {
				if (leftMaxHeight <= rightMaxHeight) {
					sum+=(leftMaxHeight - arr[i]);
				} else {
					sum+=(rightMaxHeight - arr[i]);
				}
			}

		}

		bw.write(sum+"");

		bw.close();
	}

}