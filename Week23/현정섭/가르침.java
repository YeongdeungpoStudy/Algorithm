package Week23.현정섭;
import java.util.*;
import java.io.*;

public class 가르침 {
    
    
    static int k;
    static int n;
    static int[] alphaArray;
    static String[] wordArray;
    static int max ;
    private static void func(int start, int cnt){

        if(cnt == k) {

			int num = 0;

			for(int i=0; i<wordArray.length; i++) {

                // 문자가 있는 지 없는지 여부
				boolean flag = true;

				for(int j=0; j< wordArray[i].length(); j++) {
					
					
					if(alphaArray[wordArray[i].charAt(j) - 97] == 0) {
						flag = false;
						break;
					}
				}
				if(flag){
                    num ++;
                }
			}
			
            max = Math.max(max, num);

			return;
		}

        for(int i = start; i<26; i++ ){
            
            if(alphaArray[i] != 1){
                alphaArray[i] = 1;
                func(start, cnt + 1);
                alphaArray[i] = 0;
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numStr = br.readLine().split(" ");

        n = Integer.parseInt(numStr[0]);
        k = Integer.parseInt(numStr[1]);

        alphaArray = new int[26];

        wordArray = new String[n];

        String condition = "antatica";

        for(int i = 0; i < condition.length(); i++){
            char ch = condition.charAt(i);
            int numCha = (int) ch;
            alphaArray[numCha - 97] = 1;
        }

        for(int i = 0; i< n; i++){
            String word = br.readLine();
            wordArray[i] = word; 
        }

        if(k < 5){
            System.out.println(0);
            return;
        }
        else if(k==26){
            System.out.println(n);
            return;
        }
        else{
            func(0,5);
        }

        System.out.println(max);

    }
}