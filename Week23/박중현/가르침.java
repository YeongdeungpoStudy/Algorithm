import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static String[] strArr;
	static int[] arr;
	static int maxNum = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 백준 가르침

		// 되도록 많은 단어를 읽게
		// K개의 글자를 가르칠 시간만 있다.

		// K개의 글자로만 이루어진 단어만을 읽을 수 있다.

		// 어떤 k개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠짐

		// antarctica
		// antahellotica
		// antacartica

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K <= 5) {
			bw.write("0");
			br.close();
			bw.flush();
			bw.close();
			return;
		}

		strArr = new String[N];

		for (int i = 0; i < N; i++) {
			strArr[i] = br.readLine();
		}

		// K >= 5
		// a n t i c -> 5개는 무조건

		arr = new int[26];

		// N >= 1 N은 무조건 1보다 크거나 같다
		for (int i = 0; i < N; i++) {
			int len = strArr[i].length();

			for (int j = 0; j < len; j++) {

				char c = strArr[i].charAt(j);

				int cNum = c - 97;

				if (isIncludedInAntarctica(c) || arr[cNum] == 1) {
					continue;
				}
				arr[cNum] = 1;
			}
		}

		// 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0
		// 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0
		// 0 0 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 1 0 0



		// a b c d e f g h i j k l m n o p q r s t u v w x y z

		backTracking(0, 0);

		bw.write(maxNum+"");

		br.close();
		bw.close();
	}

	private static void backTracking(int idx, int count) {
		// a b c d e f g h i j k l m n

		if (count == K-5) {
			int readCount = 0;

			for (int i = 0; i < N; i++) {
				boolean canRead = true;
				String toReadStr = strArr[i];

				for (int j = 0; j < toReadStr.length(); j++) {
					if (arr[toReadStr.charAt(j) - 97] == 1) {
						canRead = false;
						break;
					}
				}

				if (canRead) {
					readCount++;
				}
			}
			maxNum = Math.max(maxNum, readCount);
			return;
		}

		for (int i = idx; i < 26; i++) {
			if (arr[i] == 1) {
				arr[i] = 0;
				backTracking(i, count+1);
				arr[i] = 1;
			}
		}
	}

	private static boolean isIncludedInAntarctica(char c) {
		if (c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c') {
			return true;
		}
		return false;
	}
}
