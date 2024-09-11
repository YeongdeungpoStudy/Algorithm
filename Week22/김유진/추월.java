import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //in
        Queue<String> in = new LinkedList<>();

        //out
        Queue<String> out = new LinkedList<>();
        Set<String> alreadyOut = new HashSet<>();

        for(int i=0;i<N;i++){
            in.add(br.readLine());
        }
        for(int i=0;i<N;i++){
            out.add(br.readLine());
        }

        int cnt = 0;
        while(!out.isEmpty()){
            String outCar = out.poll();
            String inCar = getInCar(in, alreadyOut);

            if(outCar.equals(inCar)){
                in.poll();
            } else {
                cnt++;
            }

            alreadyOut.add(outCar);
        }

        System.out.print(cnt);
    }

    static String getInCar(Queue<String> in, Set<String> alreadyOut){
        while(!in.isEmpty()){
            String inCar = in.peek();

            if(alreadyOut.contains(inCar)){
                in.poll();
                continue;
            } else {
                return inCar;
            }
        }

        return "";
    }
}
