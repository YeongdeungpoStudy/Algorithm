package Week27.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 골드바흐의추측 {
    static int[] primeNum = new int[10000];
    static boolean[] chk = new boolean[10001];//true면 소수아님
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        chk[0] = chk[1] = true;
        findPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int ans1 = 100000;
            int ans2 = -100000;
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < idx; j++) {
                if (primeNum[j]>num){
                    break;
                }
                int num1 = primeNum[j];
                int num2 = num - primeNum[j];
                if (!chk[num2]&&Math.abs(num1-num2)<Math.abs(ans1-ans2)){
                    ans1 = Math.max(num1, num2);
                    ans2 = Math.min(num1, num2);
                }
            }
            System.out.println(ans2+" "+ans1);
        }
    }
    private static void findPrime(){
        for (int i = 2; i < 10000; i++) {
            if (chk[i]) {
                continue;
            }
            primeNum[idx++] = i;
            for (int j = i+i; j < 10000; j+=i) {
                chk[j] = true;
            }
        }
    }
}