package Week20.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 개똥벌레 {
    //이분탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(str.nextToken());
        int h = Integer.parseInt(str.nextToken());

        int [] top = new int[n/2];
        int [] bottom = new int[n/2];

        for (int i = 0; i < n / 2; i++) {
            bottom[i] = Integer.parseInt(br.readLine());
            top[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bottom);
        Arrays.sort(top);

        int min = 10000000;
        int cnt = 0;

        for (int i = 1; i <= h; i++) {
            int bottomNum = bin(bottom, i);
            int topNum = bin(top, h - i + 1);

            int totalNum = bottomNum + topNum;
            if (totalNum < min){
                min = totalNum;
                cnt = 1;
            } else if (totalNum == min) {
                cnt++;
            }

        }

        System.out.println(min + " " + cnt);

    }

    private static int bin(int[] array, int num) {
        int s = 0;
        int e = array.length;

        while (s < e) {

            int mid = (s + e) / 2;

            if (array[mid] >= num) {
                e = mid;
            } else {
                s = mid+1;
            }


        }
        return array.length - s;

    }

}

//누적합 풀이

//import java.io.*;
//
//public class Main {
//
//    static int N, H;
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String[] input = br.readLine().split(" ");
//        N = Integer.parseInt(input[0]);
//        H = Integer.parseInt(input[1]);
//
//        int[] bot = new int[H + 2];
//        int[] top = new int[H + 2];
//
//        for (int i = 0; i < N / 2; i++) {
//            bot[Integer.parseInt(br.readLine())]++;
//            top[H - Integer.parseInt(br.readLine()) + 1]++;
//        }
//
//        for (int i = 1; i <= H; i++) {
//            bot[i] += bot[i - 1];
//        }
//
//        for (int i = H; i >= 1; i--) {
//            top[i] += top[i + 1];
//        }
//
//        int min = N;
//        int cnt = 0;
//
//        for (int i = 1; i <= H; i++) {
//            int obs = (bot[H] - bot[i - 1]) + (top[1] - top[i + 1]);
//
//            if (obs < min) {
//                min = obs;
//                cnt = 1;
//            } else if (obs == min)
//                cnt++;
//        }
//
//        bw.write(min + " " + cnt + "\n");
//        bw.flush();
//
//    }
//
//}
