import java.util.Scanner;

public class 달팽이 {
    //https://www.acmicpc.net/problem/1913
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int targetNum = sc.nextInt();

        int[][] arr = new int[n][n];
        int num = 1, move = 1;
        int x = n/2, y = n/2;

        while (true){
            for (int i = 0; i < move; i++) {
                arr[y--][x] = num++;
            }

            if (num>n*n) break;

            for (int i = 0; i < move; i++) {
                arr[y][x++] = num++;
            }
            move++;
            for (int i = 0; i < move; i++) {
                arr[y++][x] = num++;
            }
            for (int i = 0; i < move; i++) {
                arr[y][x--] = num++;
            }
            move++;
        }

        StringBuilder sb = new StringBuilder();

        int ans_x = 0;
        int ans_y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
                if(arr[i][j] == targetNum){
                    ans_x = i+1;
                    ans_y = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(ans_x).append(" ").append(ans_y);
        System.out.println(sb.toString());
    }
}
