package Week24;
import java.io.*;
import java.util.*;

public class 방_번호 {

    static int count;
    static int[] order;
    static int answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] stringArray = br.readLine().split("");

        int[] doorArray = Arrays.stream(stringArray)
                                .mapToInt(Integer::parseInt)
                                .toArray();

        int[] plasticArray = new int[10]; 

        for(int i = 0; i < doorArray.length; i++){
            if(doorArray[i] != 6 && doorArray[i] != 9){
                plasticArray[doorArray[i]] += 1;
            }
            else{
                if(plasticArray[6] >= plasticArray[9]){
                    plasticArray[9] += 1;
                }
                else{
                    plasticArray[6] += 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < plasticArray.length; i++) {
            answer = Math.max(answer, plasticArray[i]);
        }

        System.out.println(answer);
	}

}
