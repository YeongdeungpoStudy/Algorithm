package Week21.권우현;

import java.util.Scanner;

public class 펠린드롬만들기 {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            String s = sc.nextLine();

            int ans = 100;
            for (int i = 0; i < 50; i++) {
                String tmp = s.substring(0,i);
                StringBuilder sb = new StringBuilder(tmp);
                sb.reverse();
                String tmp2 = sb.toString();
                String tmp3 = s+tmp2;
                if(chkPalindrome(tmp3)){
                    ans = i;
                    break;
                }
            }

            if (ans==100){
                System.out.println(100);
                return;
            }
            System.out.println(ans+s.length());

    }

    private static boolean chkPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while (start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}