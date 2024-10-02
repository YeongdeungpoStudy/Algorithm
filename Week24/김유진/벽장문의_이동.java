import java.util.*;
import java.io.*;


class Main{
    static int N;
    static LinkedList<Integer> seq;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        String[] AB = br.readLine().split(" ");
        
        int a = Integer.parseInt(AB[0]);
        int b = Integer.parseInt(AB[1]);
        
        seq = new LinkedList<>();
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            seq.add(Integer.parseInt(br.readLine()));
        }
        
        backTracking(0, a, b);
        
        System.out.print(min);
    }
    
    static void backTracking(int cnt, int a, int b){
        if(seq.isEmpty()){
            if(cnt < min){
                min = cnt;
            }
            
            return;
        }
        
        if(cnt > min){
            return;
        }
        
        //a로 옮기기
        int next = seq.poll();
        backTracking(cnt+calcualteCnt(a, next), next, b);
        seq.addFirst(next);
        
        //b로 옮기기 
        next = seq.poll();
        backTracking(cnt+calcualteCnt(b, next), next, a);
        seq.addFirst(next);
    }
    
    static int calcualteCnt(int a, int b){
        return Math.abs(a-b);
    }
    
    
}
