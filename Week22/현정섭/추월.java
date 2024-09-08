package Week22.현정섭;
import java.util.*;
import java.io.*;

class 추월{

    public static void main(String arg[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> dequeA = new ArrayList<>();

        ArrayList<String> dequeB = new ArrayList<>();

        int value = 0;

        for(int i = 0; i < n; i++){
            String carNum = br.readLine();

            dequeA.add(carNum);

        }

        for(int i = 0; i < n; i++){
            String carNum = br.readLine();

            dequeB.add(carNum);
        }

        // System.out.println(dequeA.toString());
        // System.out.println(dequeB.toString());
        int index = 0;

        while(!dequeB.isEmpty()){
            if(dequeA.get(index).equals(dequeB.get(index))){
                dequeA.remove(index);
                dequeB.remove(index);
                value += 1;
            }
            else{
                dequeA.remove(dequeB.get(index));
                dequeB.remove(index);
                
            }
        }

        System.out.println(n - value);

    }

}