import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문자열에 대해 공부
		// 규완이는 팰린드롬을 엄청 조항한다.
		// 팰린드롬은 앞에서부터 읽으나 뒤에서부터 읽으나 같게 읽히는 문자열

		// abab -> ababa 5
		// abacaba -> abacaba 7
		// qwerty -> qwertytrewq 11

		String str = br.readLine();

		// int leftIdx = 0;
		// int rightIdx = str.length() - 1;

		int palindromCount = str.length();

		// [a]ba[b]
		// a[b]a[b]
		// ab [[a]] b

		// [q]wert[y]
		// q[w]ert[y]
		// qw[e]rt[y]
		// qwe[r]t[y]
		// qwer[t][y]

		// a b b c a
		// [a] b b c [a]
		// a [b] b [c] a  +1
		// a b [b] [c] a  +1
		// a b b c a

		// 단순 투포인터로 접근 해결 X
		// while (leftIdx < rightIdx) {
		// 	if (str.charAt(leftIdx) == str.charAt(rightIdx)) {
		// 		leftIdx++;
		// 		rightIdx--;
		// 		continue;
		// 	}
		//
		// 	leftIdx++;
		// 	palindromCount++;
		// }

		for (int i = 0; i < str.length(); i++) {
			if (isPalindrom(str.substring(i, str.length()))) {
				break;
			}
			palindromCount++;
		}

		bw.write(palindromCount + "");

		br.close();
		bw.close();
	}

	private static boolean isPalindrom(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
