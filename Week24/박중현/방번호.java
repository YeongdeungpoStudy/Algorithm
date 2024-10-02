import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static String[] strArr;
	static int[] arr;
	static int maxNum = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 방번호
		// 다솜이는 은진이 옆집에 새로 이사왔다.
		// 다솜이는 자기 방번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
		// 다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다.

		String str = br.readLine();

		// 한 세트 0 ~ 9
		// 9999 - > 6도 가능 9도 가능

		int[] charNumArr = new int[10];

		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			charNumArr[num]++;
		}

		int sixNum = charNumArr[6] + charNumArr[9];
		charNumArr[6] = (sixNum + 1) / 2;
		charNumArr[9] = (sixNum + 1) / 2;

		int maxNum = 0;

		for (int i = 0; i < 9; i++) {
			maxNum = Math.max(maxNum, charNumArr[i]);
		}

		bw.write(maxNum+"");

		br.close();
		bw.close();
	}

}
