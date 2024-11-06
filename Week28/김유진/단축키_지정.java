import java.util.*;
import java.io.*;

public class Main {
    static boolean[] assigned = new boolean['z' - 'a'+1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringJoiner sj = new StringJoiner("\n");
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String fullOption = br.readLine();
            String[] options = fullOption.split(" ");

            sb.setLength(0);
            boolean complete = false;

            //단어 첫글자 옵션 확인
            for (String option : options) {
                if (complete) {
                    sb.append(option).append(" ");
                    continue;
                }

                char firstAlpha = option.charAt(0);

                if (isAssigned(firstAlpha)) {
                    sb.append(option).append(" ");
                    continue;
                }

                assign(firstAlpha);
                complete = true;
                String remained = option.substring(1);

                sb.append("[").append(firstAlpha).append("]").append(remained).append(" ");
            }

            if (complete) {
                sj.add(sb.toString().trim());
                continue;

            } else {
                sb.setLength(0);
            }

            //전체 풀 스캔
            for (char alpha : fullOption.toCharArray()) {
                if (complete) {
                    sb.append(alpha);

                    continue;
                }

                if (alpha == ' ' || isAssigned(alpha)){
                    sb.append(alpha);

                    continue;
                }

                complete = true;
                assign(alpha);
                sb.append("[").append(alpha).append("]");
            }

            sj.add(sb.toString().trim());
        }

        System.out.print(sj);
    }

    private static void assign(char alphabet) {
        if (alphabet < 'a') {
            alphabet += 'a' - 'A';
        }

        assigned[alphabet - 'a'] = true;
    }

    private static boolean isAssigned(char alphabet) {
        if (alphabet < 'a') {
            alphabet += 'a' - 'A';
        }

        return assigned[alphabet - 'a'];
    }
}
