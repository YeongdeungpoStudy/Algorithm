import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int GCD(int x, int y) { //유클리드 호제법
        int r = x%y;
        if (r == 0) {
            return y;
        }else {
            return GCD(y, r);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            long sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum += GCD(arr[j], arr[k]);
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.println(sb.toString());
    }
}