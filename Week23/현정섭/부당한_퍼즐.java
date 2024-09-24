package Week23.현정섭;
import java.util.*;
import java.io.*;


public class 부당한_퍼즐 {
 
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        String numStr = br.readLine();
        
        String[] numOrg = numStr.split(" ");

        String numStr2 = br.readLine();
        
        String[] numQs = numStr2.split(" ");

        ArrayList<String> org = new ArrayList<>();

        ArrayList<String> qs = new ArrayList<>();

        for(int i = 0; i < n; i++){

            org.add(numOrg[i]);

        }

        for(int i = 0; i < n; i++){

            qs.add(numQs[i]);

        }

        // 오리지날 수열 deep copy
        ArrayList<String> rev = new ArrayList<>(org);

        //reverse
        Collections.reverse(rev);

        String answer1 = "good puzzle";
        String answer2 = "good puzzle";

        //오리지날 수열의 첫번째 값을 문제 수열에 찾기
        int s1 = qs.indexOf(org.get(0));

        //오리지날 수열과 문제 수열 비교
        for(int i = 0; i < n; i++){

            if(!(org.get(i).equals(qs.get((s1+i)%n)))){
                answer1 = "bad puzzle";
                break;
            }

        }

        //리버스 수열의 첫번째 값을 문제 수열에 찾기
        int s2 = qs.indexOf(rev.get(0));
        
        //리버스 수열과 문제 수열 비교
        for(int i = 0; i < n; i++){

            if(!(rev.get(i).equals(qs.get((s2+i)%n)))){
                answer2 = "bad puzzle";
                break;
            }
            
        }

        System.out.println(answer1.equals("good puzzle") | answer2.equals("good puzzle") ? "good puzzle" : "bad puzzle" );

    }

}