import java.util.Scanner;

public class BOJ1475 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 입력
        int n = scan.nextInt();
        int[] arr = new int[10];
        int answer = 0;

        while( n > 0) {
          int x = n % 10;
          n = n  / 10;

          arr[x]++;

          if(x == 6 || x == 9) {
              int sum = arr[6] + arr[9];

              if(sum % 2 == 1) {
                  sum = sum / 2 + 1;
              }else {
                  sum = sum / 2;
              }
              answer = Math.max(answer, sum);
          }else {
              answer = Math.max(answer, arr[x]);
          }
        }

        System.out.println(answer);
    }
}