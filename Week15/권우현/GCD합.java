import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD합 {
    //https://www.acmicpc.net/problem/9613
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer str;
        for (int i = 0; i < t; i++) {
            str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int[] num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(str.nextToken());
            }
            long ans = 0;
            for (int j = 0; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    ans+=gcd(num[k], num[j]);
                }
            }
            System.out.println(ans);
        }
    }

    private static long gcd(int a, int b){
        int A = Math.max(a,b);
        int B = Math.min(a,b);

        while (true){
            if(A%B == 0) return B;

            int tmp = B;
            B = A%B;
            A = tmp;
        }
    }
}
