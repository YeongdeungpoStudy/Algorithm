package Week24.권우현;

import java.util.Scanner;

public class 방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[9];
        while (true){
            if (n==0) break;
            if (n/10==0){
                if (n!=9){
                    num[n]++;
                }
                else num[6]++;
                break;
            }
            else {
                if (n%10!=9){
                    num[n%10]++;
                }
                else num[6]++;
                n/=10;
            }
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            if (i!=6){
                max = Math.max(max, num[i]);
            }
            else {
                max = Math.max(max, (num[i]+1)/2);
            }
        }
        System.out.println(max);
    }
}
