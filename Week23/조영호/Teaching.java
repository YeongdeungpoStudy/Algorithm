package Week23.조영호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Teaching {
    static int n;
    static int k;
    static String[] words;
    static boolean[] alphaArr = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        // anta, tica에 들어가는 5개의 알파벳은 항상 사용되므로 true로 처리해줍니다.
        alphaArr['a' - 'a'] = true;
        alphaArr['n' - 'a'] = true;
        alphaArr['t' - 'a'] = true;
        alphaArr['i' - 'a'] = true;
        alphaArr['c' - 'a'] = true;

        if (k < 5) {
            // k가 5 미만인 경우에는 모든 단어를 완성할 수 없으므로 0을 출력합니다.
            System.out.println(max);
        } else {
            dfs(0, 0);
            System.out.println(max);
        }
    }

    // 학생들에게 가르칠 k개의 알바벳의 조합을 구합니다.
    public static void dfs(int idx, int cnt) {
        // 학생들이 k개의 알파벳을 배웠으므로 읽을 수 있는 단어의 개수를 구합니다.
        if (cnt + 5 == k) {
            countWord();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (alphaArr[i]) {
                continue;
            }

            alphaArr[i] = true;
            dfs(i + 1, cnt + 1);
            alphaArr[i] = false;
        }
    }

    // 학생들이 읽을 수 있는 단어의 개수를 구합니다.
    public static void countWord() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char[] alphas = words[i].toCharArray();
            boolean flag = true;
            for (char c: alphas) {
                if (!alphaArr[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
}
