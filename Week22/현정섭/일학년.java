package Week22.현정섭;
import java.util.*;
import java.io.*;

public class 일학년 {
 
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // input 값 넣을 배열
        int [] arr = new int[n];
        
        // 답이 2^63-1 이하로 명시되어 있으니 타입을 long으로 설정
        long [][] dp = new long[n][21];
 
        String str = br.readLine();
        
        String[] strArr = str.split(" ");
        
        // 문자 -> 숫자로 타입변경
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        // 첫번째 값은 무조건 경우의 수가 1이므로 1로 dp 배열에 1로 설정
        dp[0][arr[0]]=1;
        
        // 더한 값 / 뺀 값 초기화
        int a = 0;
        int b = 0;

        // input 값 돌아가면서 계산
        for(int i=1; i<n-1; i++){

            // 0 ~ 20 까지 중 계산 결과의 index에 더해준다 
            for(int j=0; j<21; j++){

                if(dp[i-1][j]!=0){

                    a = j+arr[i];
                    b = j-arr[i];
                    
                    if(a>=0 && a<=20){

                        dp[i][a]+=dp[i-1][j];

                    }

                    if(b>=0 && b<=20){

                        dp[i][b]+=dp[i-1][j];

                    }
                }
            }
        }
 
        System.out.println(dp[n-2][arr[n-1]]);
 
    }
}