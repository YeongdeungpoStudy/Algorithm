package Week28.현정섭;
import java.io.*;
import java.util.*;

public class 단축키_지정{

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Character> shorts = new ArrayList<>();

        for(int i=0; i < n; i++){ 

            String word = br.readLine();

            String[] wordArray = word.split(" ");

            boolean flag = false;

            for(int j = 0; j < wordArray.length; j++){
                if(!shorts.contains(Character.toUpperCase(wordArray[j].charAt(0)))){
                    shorts.add(Character.toUpperCase(wordArray[j].charAt(0)));
                    flag = true;
                    wordArray[j] = "[" + wordArray[j].charAt(0) + "]" + wordArray[j].substring(1) ;
                    System.out.println(String.join(" ", wordArray));
                    break;
                }
            }

            //System.out.println(shorts.toString());

            if(!flag){
                for(int k = 0; k < wordArray.length; k++){

                    boolean check = false;

                    for(int l = 0; l < wordArray[k].length(); l++){
                        //System.out.println(Character.toUpperCase(wordArray[k].charAt(l)));
                        if(!shorts.contains(Character.toUpperCase(wordArray[k].charAt(l)))){
                            shorts.add(Character.toUpperCase(wordArray[k].charAt(l)));
                            flag = true;
                            check = true;
                            wordArray[k] = wordArray[k].substring(k,l) + "[" + wordArray[k].charAt(l) + "]" + wordArray[k].substring(l+1);
                            System.out.println(String.join(" ", wordArray));
                            break;
                        }
                    }

                    if(check)
                         break;

                }
            }

            if(!flag){
                System.out.println(String.join("", wordArray));
            }

        

    
    }
}
}