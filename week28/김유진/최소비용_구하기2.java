import java.util.*;
import java.io.*;

class Bus implements Comparable<Bus>{
    int end;
    List<Integer> history;
    long cost;

    public Bus(int end, List<Integer> history, long cost){
        this.end=end;
        this.history = history;
        this.cost = cost;
    }

    public int compareTo(Bus p){
        return Long.compare(this.cost, p.cost);
    }
}

class Main{
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i=0;i<M;i++){
            String[] bus = br.readLine().split(" ");
            int start = Integer.parseInt(bus[0]);
            int end = Integer.parseInt(bus[1]);
            int cost = Integer.parseInt(bus[2]);

            if(dp[start][end] != -1 && dp[start][end] < cost){
                continue;
            }

            dp[start][end] = cost;
        }

        String[] dest = br.readLine().split(" ");
        int start = Integer.parseInt(dest[0]);
        int end = Integer.parseInt(dest[1]);

        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Bus> queue = new PriorityQueue<>();
        dist[start] = 0;
        //start -> 다른 노드
        for(int i=1;i<=N;i++){
            if(dp[start][i] != -1){
                List<Integer> history = new ArrayList<>();
                history.add(start);
                history.add(i);

                queue.add(new Bus(i, history, dp[start][i]));
            }
        }

        Bus res=null;
        while(!queue.isEmpty()){
            Bus bus = queue.poll();
            int busDest = bus.end;
            long busCost = bus.cost;
            List<Integer> busHistory = bus.history;

            if(dist[busDest] < busCost){
                continue;
            }

            dist[busDest] = busCost;

            if(busDest == end){
                res = bus;

                break;
            }

            for(int i=1;i<=N;i++){
                if(dp[busDest][i] == -1){
                    continue;
                }

                if(dist[i] <= busCost + dp[busDest][i]){
                    continue;
                }

                List<Integer> newHistory = new ArrayList<>(busHistory);
                newHistory.add(i);

                queue.add(new Bus(i, newHistory,dp[busDest][i] + busCost));
            }
        }

        System.out.print(res.cost+"\n"+res.history.size()+"\n"+getHistory(res.history));
    }

    static String getHistory(List<Integer> history){
        StringJoiner sj = new StringJoiner(" ");
        for(int node:history){
            sj.add(Integer.toString(node));
        }

        return sj.toString();
    }
}
