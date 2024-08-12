import java.util.*;
import java.io.*;

class Student{
    int number;
    List<Integer> bigger = new ArrayList<>();
    List<Integer> smaller = new ArrayList<>();

    public Student(int number){
        this.number = number;
    }

    void addBigger(int index){
        bigger.add(index);
    }

    void addSmaller(int index){
        smaller.add(index);
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Student[] students = new Student[N+1];
        for(int i=1;i<=N;i++){
            students[i] = new Student(i);
        }

        while(M-->0){
            st = new StringTokenizer(br.readLine());

            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());

            students[small].addBigger(big);
            students[big].addSmaller(small);
        }

        int cnt = 0;
        for(int i=1;i<=N;i++){
            boolean[] visited = new boolean[N+1];

            //small
            Queue<Integer> smalls = new LinkedList<>();
            for(int small:students[i].smaller){
                smalls.add(small);
                visited[small] = true;
            }
            int smallCnt = 0;
            while(!smalls.isEmpty()){
                int newSmall = smalls.poll();
                smallCnt++;

                for(int small:students[newSmall].smaller){
                    if(visited[small]){
                        continue;
                    }

                    visited[small] = true;
                    smalls.add(small);
                }
            }

            //big
            Queue<Integer> bigs = new LinkedList<>();
            for(int big:students[i].bigger){
                bigs.add(big);
                visited[big] = true;
            }

            int bigCnt = 0;
            while(!bigs.isEmpty()){
                int newBig = bigs.poll();
                bigCnt++;

                for(int big:students[newBig].bigger){
                    if(visited[big]){
                        continue;
                    }

                    visited[big] = true;
                    bigs.add(big);
                }
            }

            if(bigCnt+smallCnt == N-1){
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
