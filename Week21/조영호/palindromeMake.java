package Week21.조영호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class palindromeMake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();

        // 1. 문자열 중간에 팰린드롬이 있는지 알아야 함! 
        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i))) {
                break;
            }
            //3. 팰린드롬 아니면 같은 문자 하나 추가해줘야 하니까 길이 1 추가
            len++;
        }
        System.out.println(len);
    }
    
    private static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        // 2. 문자열 맨 앞, 맨 뒤부터 좁혀가면서 팰린드롬인지 확인
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
