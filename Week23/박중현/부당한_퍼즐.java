import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 플레이어는 1 ~ n 까지 숫자가 한 번씩만 나타나는 수열을 하나 가지고 시작한다.
		// 또 다른 1 ~ n 까지 숫자가 한 번씩만 나타나는 수열이 주어졌을 때
		// 처음 수열을 적절히 변형해서 처음 받은 수열을 이 수열과 동일한 수열로 만들어야한다.

		// 1 2 3 4 5 6 ...
		// 뒤집기 가능
		// 밀기 가능

		int n = Integer.parseInt(br.readLine());

		StringBuilder sbArr = new StringBuilder();

		StringBuilder sbDoubleArr = new StringBuilder();

		StringBuilder sbTargetArr = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			// arr[i] = Integer.parseInt(st.nextToken());
			sbArr.append(st.nextToken());
		}

		sbDoubleArr.append(sbArr).append(sbArr);

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			// targetArr[i] = Integer.parseInt(st.nextToken());
			sbTargetArr.append(st.nextToken());
		}

		String sbDoubleStr = sbDoubleArr.toString();
		String targetStr = sbTargetArr.toString();
		String reverseTargetStr = sbTargetArr.reverse().toString();

		if (isIncluded(targetStr, sbDoubleStr) || isIncluded(reverseTargetStr, sbDoubleStr)) {
			bw.write("good puzzle");
		} else {
			bw.write("bad puzzle");
		}

		br.close();
		bw.close();
	}

	private static boolean isIncluded(String arr, String doubleArr) {

		if (doubleArr.contains(arr)) {
			return true;
		}

		return false;
	}
}
