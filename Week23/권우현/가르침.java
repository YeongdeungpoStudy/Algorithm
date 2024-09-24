package Week23.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가르침 {
    static int n, k;
    static boolean[] chk = new boolean[26];
    static String[] words;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);
        words = new String[n];
        if (k < 5){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            words[i] = s.substring(4, s.length() - 4);
        }
        chk['a' - 'a'] = true;
        chk['n' - 'a'] = true;
        chk['t' - 'a'] = true;
        chk['i' - 'a'] = true;
        chk['c' - 'a'] = true;

        dfs(0,0);
        System.out.println(max);
    }

    private static void dfs(int letter, int depth) {
        if (depth == k - 5){
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!chk[words[i].charAt(j) - 'a']){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    tmp++;
                }
            }
            max = Math.max(max, tmp);
            return;
        }
        for (int i = letter; i < 26; i++) {
            if (!chk[i]){
                chk[i] = true;
                dfs(i, depth + 1);
                chk[i] = false;
            }
        }
    }
}