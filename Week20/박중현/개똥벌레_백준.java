import java.awt.*;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 개똥벌레 한 마리가 장애물로 가득찬 동굴에 들어갔다.
		// 동굴의 길이는 N미터 높이는 H미터
		// 자신이 지나갈 구간을 정한 다음 일직선으로 지나가면서 만나는 모든 장애물을 파괴한다.

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 동굴의 길이
		int H = Integer.parseInt(st.nextToken()); // 동굴의 높이

		int[] hurdlesDown = new int[N/2];
		int[] hurdlesUp = new int[N/2];

		for (int i = 0; i < N; i++) {
			int hurdle = Integer.parseInt(br.readLine());
			if (i % 2 == 1) {
				hurdlesUp[i/2] = hurdle;
			} else {
				hurdlesDown[i/2] = hurdle;
			}
		}

		Arrays.sort(hurdlesDown);
		Arrays.sort(hurdlesUp);

		int leastHurdleNum = Integer.MAX_VALUE;

		int count = 0;
		for (int i = 1; i <= H; i++) {
			int downHurdleNum = binarySearch(0, N/2, i, hurdlesDown);
			int upHurdleNum = binarySearch(0, N/2, H - i + 1, hurdlesUp);

			if (downHurdleNum + upHurdleNum < leastHurdleNum) {
				leastHurdleNum = downHurdleNum + upHurdleNum;
				count = 1;
			} else if (downHurdleNum + upHurdleNum == leastHurdleNum) {
				count++;
			}
		}

		bw.write(leastHurdleNum + " " + count);

		br.close();
		bw.close();
	}

	private static int binarySearch(int left, int right, int bugHeight, int[] arr) {

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= bugHeight) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return arr.length - right; // 벌레의 높이 이상의 장애물 개수
	}
}
