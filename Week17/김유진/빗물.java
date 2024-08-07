import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] rains = new int[W];

        for(int i=0;i<W;i++){
            rains[i] = Integer.parseInt(st.nextToken());
        }

        //구현
        int index = 0;
        int result = 0;
        while(index < W){
            boolean find = false;

            //1. 만족하는 거 찾음
            for(int i=index+1; i<W; i++){
                if(rains[index] <= rains[i]){
                    for(int j=index+1; j<i; j++){
                        result += rains[index] - rains[j];
                    }

                    index = i;
                    find = true;
                    break;
                }
            }

            //2. 만족하는 거 못찾음
            if(!find){
                //현재 index~최대한 큰 거 끝까지 찾아서
                int max = Integer.MIN_VALUE;
                int maxIdx = -1;

                for(int i = index +1;i<W;i++){
                    if(max < rains[i]){
                        max = rains[i];
                        maxIdx = i;
                    }
                }

                if(maxIdx == -1){
                    break;
                }

                for(int i = index +1; i<maxIdx ; i++){
                    result +=  max - rains[i];
                }

                index = maxIdx;
            }
        }

        System.out.print(result);
    }
}
