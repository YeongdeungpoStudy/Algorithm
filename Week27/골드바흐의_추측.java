package Week27;
import java.util.*;
import java.io.*;

public class 골드바흐의_추측 {

    public static void main(String[] args) throws IOException {

        boolean[] primeNumbers = new boolean[10001];

        primeNumbers[0] = true;
        primeNumbers[1] = true;

        for(int i=2; i < (int)Math.sqrt(10000) + 1 ; i++ ){
            
            if(primeNumbers[i] == true){
                continue;
            };

            for(int j=i*i; j < 10001; j += i){
                primeNumbers[j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            
            int m = Integer.parseInt(br.readLine());
            
            for(int j = m/2; j > 0; j-=1){
                if(primeNumbers[j] == false && primeNumbers[m-j] == false){
                    System.out.println(j + " " + (m-j));
                    break;
                }
            }

        }

    }

}