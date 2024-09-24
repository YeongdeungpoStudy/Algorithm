package Week23.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부당한_퍼즐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] original = new int[n];
        int[] puzzle = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            original[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            puzzle[i] = Integer.parseInt(input[i]);
        }

        int first = original[0];
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (puzzle[i] == first) {
                num = i;
                break;
            }
        }

        boolean isSame = true;

        // 정방향 비교
        for (int i = 0; i < n; i++) {
            if (original[i] != puzzle[(num + i) % n]) {
                isSame = false;
                break;
            }
        }

        if (isSame) {
            System.out.println("good puzzle");
            return;
        }

        // 역방향 비교
        isSame = true;
        for (int i = 0; i < n; i++) {
            if (original[i] != puzzle[(num - i + n) % n]) {
                isSame = false;
                break;
            }
        }

        if (isSame) {
            System.out.println("good puzzle");
        } else {
            System.out.println("bad puzzle");
        }
    }
}
