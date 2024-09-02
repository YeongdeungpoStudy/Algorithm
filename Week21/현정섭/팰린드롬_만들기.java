package Week21.현정섭;

import java.io.*;
import java.util.*;

class 팰린드롬_만들기{

    
    private static boolean checkFunc(String text){

        boolean check = true;
        int start = 0;
        int end = text.length() - 1;

        while(start <= end){

            if(text.charAt(start) == text.charAt(end)){
                start += 1;
                end -= 1;
            }
            else{
                check = false;
                return check;
            }

        }
            
        return check;

    }

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();

        int i = 0;

        int answer = text.length();

        // while 돌면서 팰린드롬 확인하고 팰린드롬이면 단어 length + 팰린드롬 아닌 부분 length
        while(true){

            // i부터 끝까지 잘라서 팰린드롬인지 확인하는 함수에 넣는다.
            if(checkFunc(text.substring(i))){
                answer += i;
                break;
            }
            // 팰린드롬 아니면 i++
            else{
                i++;
            }
        }

        System.out.println(answer);
    };

}