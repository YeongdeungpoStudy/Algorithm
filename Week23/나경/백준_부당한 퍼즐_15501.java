import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] inputArr = new int[n];
        int[] outputArr = new int[n];

        for(int i=0; i<n; i++) {
            inputArr[i] = Integer.parseInt(st1.nextToken());
            outputArr[i] = Integer.parseInt(st2.nextToken());
        }

        //로직
        boolean answer1 = true, answer2 = true;

        int start = outputArr[0];
        int idx = 0;

        //시작점 찾기
        while(start != inputArr[idx]) {
            idx++;
        }

        //앞에서 뒤로 확인하기
        for(int i=0; i<n; i++) {
            if(outputArr[i] != inputArr[(idx+i) % n]) {
                answer1 = false;
                break;
            }
        }

        //뒤에서 앞으로 확인하기
        for(int i=0; i<n; i++) {
            if(outputArr[i] != inputArr[(idx - i + n) % n]) {
                answer2 = false;
            }
        }

        //출력
        if(answer1 || answer2) {
            System.out.println("good puzzle");
        }else {
            System.out.println("bad puzzle");
        }
    }
}
