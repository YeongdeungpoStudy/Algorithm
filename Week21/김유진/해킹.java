import java.util.*;
import java.io.*;

class Computer {
    int index;
    int minutes;

    public Computer(int index, int minutes){
        this.index = index;
        this.minutes=minutes;
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //의존성 정의
            List<Computer>[] parents = new ArrayList[n+1];
            for(int i=1;i<=n;i++){
                parents[i] = new ArrayList<>();
            }

            while(d-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                //b가 감염되면 a도 감염
                parents[b].add(new Computer(a, s));
            }

            //로직 시작
            int[] minutes = new int[n+1];
            Arrays.fill(minutes, Integer.MAX_VALUE);

            PriorityQueue<Computer> queue = new PriorityQueue<>((Computer a,Computer b) -> Integer.compare(a.minutes, b.minutes));
            queue.add(new Computer(c, 0));

            while(!queue.isEmpty()){
                Computer computer = queue.poll(); // 감염된 컴퓨터
                if(minutes[computer.index] <= computer.minutes){
                    continue;
                }

                minutes[computer.index] = computer.minutes;

                for(Computer near: parents[computer.index]){
                    if(minutes[near.index] <= near.minutes + computer.minutes){
                        continue;
                    }

                    queue.add(new Computer(near.index, near.minutes+ computer.minutes));
                }
            }

            int cnt = 0;
            int max = 0;
            for(int i=1;i<=n;i++){
                if(minutes[i] == Integer.MAX_VALUE){
                    continue;
                }

                cnt++;

                if(max < minutes[i]){
                    max = minutes[i];
                }
            }

            System.out.println(cnt+" "+max);
        }
    }
}
