package Week24.권우현;

import java.util.Scanner;

public class 삼각형만들기 {
    public static void main(String[] args) {
        //삼각형 만들 수 있는 조건 a+b>c -> a,b,a+b가 다 달라야 함.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a; b < n; b++) {
                int c = n - a - b;

                if (b > c)
                    break;

                if (a + b > c)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}