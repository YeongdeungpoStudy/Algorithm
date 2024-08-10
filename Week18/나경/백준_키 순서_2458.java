import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int max = n * (n * (n - 1) / 2); //최대값

        int[][] student = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                student[i][j] = max;
            }
        }

        for(int i = 0; i < m; i++) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            student[n1 - 1][n2 - 1] = 1;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    student[i][j] = Math.min(student[i][j], student[i][k] + student[k][j]);
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(student[i][j] < max || student[j][i] < max) count++;
            }
            if(count == n - 1) result++;
        }

        System.out.println(result);
    }
}
