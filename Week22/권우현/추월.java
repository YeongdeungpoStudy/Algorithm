package Week22.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 추월 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), i);
        }

        int cnt = 0;
        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            out[i] = map.get(br.readLine());
        }

        // 추월 여부 계산
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (out[i] > out[j]) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
