import java.io.*;
import java.util.*;

public class Main {
    public static boolean cango(int i, int j, int direction, int[][] arr, int n ) {
        boolean flag = true;

        switch(direction) {
            case 0: i++; break;
            case 1: j++; break;
            case 2: i--; break;
            case 3: j--; break;
        }
        if(i < 1 || j < 1 || i > n || j > n || arr[i][j] != 0) {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scan.nextInt();
        int k = scan.nextInt();

        int[][] arr = new int[n+1][n+1];

        int value = n*n;
        int i=0;
        int j=1;
        int direction=0; //0: 아래, 1: 오른쪽, 2: 위, 3: 왼쪽
        int isBlock = 0;

        while(isBlock < 4 && value > 0) {
            if (cango(i, j, direction, arr, n)) {
                switch(direction) {
                    case 0: i++; break;
                    case 1: j++; break;
                    case 2: i--; break;
                    case 3: j--; break;
                }
                arr[i][j] = value--;
                isBlock = 0;
            } else {
                direction = (direction + 1) % 4;
                isBlock++;
            }
        }

        int[] position = new int[2];
        for(i=1; i<=n; i++) {
            for(j=1; j<=n; j++) {
                sb.append(String.valueOf(arr[i][j])).append(" ");

                if(arr[i][j] == k) {
                    position[0] = i;
                    position[1] = j;
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
        System.out.println(position[0] + " " + position[1]);
    }

}