package Week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 단축키지정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        HashSet<Character> scKey = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean flag = false;

            // 첫 글자들부터
            for (int j = 0; j < words.length; j++) {
                char first = Character.toLowerCase(words[j].charAt(0));

                if (!scKey.contains(first)) {
                    scKey.add(first);
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    flag = true;
                    sb.append(String.join(" ", words)).append("\n");
                    break;
                }
            }

            // 앞에서부터 차례대로
            if (!flag) {
                for (int j = 0; j < line.length(); j++) {
                    char ch = Character.toLowerCase(line.charAt(j));
                    if (ch != ' ' && !scKey.contains(ch)) {
                        scKey.add(ch);
                        line = line.substring(0, j) + "[" + line.charAt(j) + "]" + line.substring(j + 1);
                        flag = true;
                        sb.append(line).append("\n");
                        break;
                    }
                }
            }

            // 자리없음.
            if (!flag) {
                sb.append(line).append("\n");
            }
        }

        System.out.println(sb);
    }
}
