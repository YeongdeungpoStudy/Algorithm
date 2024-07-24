import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] maps = new int[N+1][N+1];

        int startR = (N+1)/2;
        int startC = (N+1)/2;
        int startValue = 1;
        int offset = 3;

        maps[startR][startC] = startValue++;

        while(startValue <= N*N){
            //상
            startR--;
            for(int i=0;i<offset-2;i++){
                maps[startR][startC++] = startValue++;
            }

            //우
            for(int i=0;i<offset;i++){
                maps[startR++][startC] = startValue++;
            }
            startR--;

            //하
            startC--;
            for(int i=0;i<offset-2;i++){
                maps[startR][startC--] = startValue++;
            }

            //좌
            for(int i=0;i<offset;i++){
                maps[startR--][startC] = startValue++;
            }
            startR++;

            offset += 2;
        }

        StringBuilder sb = new StringBuilder();

        int value = Integer.parseInt(br.readLine());

        int row=0, col=0;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                sb.append(maps[i][j]).append(" ");
                if(maps[i][j] == value){
                    row = i;
                    col=j;
                }
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        sb.append(row).append(" ").append(col);

        System.out.print(sb);
    }
}
