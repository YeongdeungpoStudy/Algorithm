package Week21.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 해킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            str = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(str.nextToken());
            int d = Integer.parseInt(str.nextToken());
            int c = Integer.parseInt(str.nextToken());

            ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();

            for (int j = 0; j <= n; j++) {
                graph.add(new HashMap<>());
            }

            for (int j = 0; j < d; j++) {
                str = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(str.nextToken());
                int b = Integer.parseInt(str.nextToken());
                int s = Integer.parseInt(str.nextToken());

                graph.get(b).put(a, s);
            }

            Queue<Integer> q = new LinkedList<>();
            int[] time = new int[n+1];

            Arrays.fill(time, 1000000000);
            time[c] = 0;


            q.offer(c);
            while (!q.isEmpty()){
                int now = q.poll();

                for (Map.Entry<Integer, Integer> tmp : graph.get(now).entrySet()) {
                    int target = tmp.getKey();
                    int cost = tmp.getValue()+time[now];

                    if (cost<time[target]){
                        time[target] = cost;
                        q.offer(target);
                    }
                }
            }

            int count = 0;
            int maxTime = 0;
            for (int j = 1; j <= n; j++) {
                if (time[j] != 1000000000) {
                    count++;
                    maxTime = Math.max(maxTime, time[j]);
                }
            }

            sb.append(count).append(" ").append(maxTime).append("\n");

        }
        System.out.println(sb);
    }
}
