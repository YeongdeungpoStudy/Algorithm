import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.*;

public class 빗물 {
    //https://www.acmicpc.net/problem/14719
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s1 = br.readLine();
        StringTokenizer str1 = new StringTokenizer(s1);
        //세로
        int H = Integer.parseInt(str1.nextToken());
        //가로
        int W = Integer.parseInt(str1.nextToken());
        //블록
        int[] block = new int[W];

        String s2 = br.readLine();
        StringTokenizer str2 = new StringTokenizer(s2);
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(str2.nextToken());
        }
        //왼쪽에서 오른쪽
        int[] max_L = new int[W];
        //오른쪽에서 왼쪽
        int[] max_R = new int[W];
        max_L[0]=block[0];

        for (int i = 1; i < W; i++) {
            if(max_L[i-1]<block[i]) {max_L[i]=block[i];}
            else max_L[i] = max_L[i-1];
        }

        max_R[W-1] = block[W-1];
        for (int i = W-2; i >= 0; i--) {
            if(max_R[i+1]<block[i]) max_R[i]=block[i];
            else max_R[i] = max_R[i+1];
        }

        int ans = 0;

        for (int i = 0; i < W; i++) {
            int wall = Math.min(max_L[i], max_R[i]);
            if(wall>block[i]) ans+=wall-block[i];
        }

        out.println(ans);
    }
}