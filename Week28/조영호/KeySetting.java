package Week28.조영호;

import java.util.Scanner;

public class KeySetting {
     public static void main(String[] args) {
		    
        Scanner sc = new Scanner(System.in);
        //입력 값을 받는다.
        int N = sc.nextInt();
        sc.nextLine();
        //해당 알파벳이 옵션에 있는지 여부
        boolean []alpha =new boolean[26];
        
        for(int i=0;i<N;i++){
            String sentense =sc.nextLine();
            String [] words=sentense.split(" ");
            boolean state= false;
            //해당 단축키의 위치
            int [] position={-1,-1};
            //앞글자 체크
            for (int j=0;j<words.length;j++) {
                char word = Character.toUpperCase(words[j].charAt(0));
                //소문자 대문자 변환

                int num = word - 'A';
                //없다면 
                if (!state && !alpha[num]) {
                    //없다면 단축키 지정하고, 반복문에서 빠져나온다.
                    alpha[num] = true;
                    position[0]=j;
                    position[1]=0;
                    state = true;
                    break;
                }
            }
            //그 다음 글자 확인
            if(!state){
                for(int j=0;j<words.length;j++){
                    for(int k=1;k<words[j].length();k++){
                        char word = Character.toUpperCase(words[j].charAt(k));
                        int nextNum=word-'A';

                        if(!alpha[nextNum]){
                            alpha[nextNum]=true;
                            position[0]=j;
                            position[1]=k;
                            state=true;
                            break;
                        }
                    }
                    if(state){
                        break;
                    }
                }
            }
            //출력
            for(int j=0;j<words.length;j++){
                for(int k=0;k<words[j].length();k++){
                    if(state && j==position[0] && k==position[1]){
                        System.out.print("["+words[j].charAt(k)+"]");
                    }else{
                        System.out.print(words[j].charAt(k));
                    }
                }
                if(j<words.length-1){
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }
}
