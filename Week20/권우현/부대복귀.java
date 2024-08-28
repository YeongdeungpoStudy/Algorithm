package Week20.권우현;

import java.util.*;

public class 부대복귀 {
    class Solution {
        public int[] solution(int n, int[][] roads, int[] src, int des) {
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < roads.length; i++) {
                int a = roads[i][0];
                int b = roads[i][1];

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int[] dis = new int[n+1];
            Arrays.fill(dis, -1);

            dis[des] = 0;

            Queue<Integer> q = new LinkedList<>();
            q.add(des);

            while (!q.isEmpty()) {
                int now = q.poll();

                for(int i = 0;i<graph.get(now).size();i++){
                    int tmp = graph.get(now).get(i);
                    if(dis[tmp]==-1){
                        dis[tmp] = dis[now]+1;
                        q.add(tmp);
                    }
                    else{
                        dis[tmp] = Math.min(dis[tmp],dis[now]+1);
                    }
                }
            }



            int[] ans = new int[src.length];

            for (int i = 0; i < src.length; i++) {
                ans[i] = dis[src[i]];
            }

            return ans;
        }
    }
}
