package Week30.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나만안되는연애 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());
        int m = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(br.readLine());
        boolean[] univ = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (str.nextToken().equals("M")) {
                univ[i] = true;
            }
        }

        List<node> map = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int univ1 = Integer.parseInt(str.nextToken());
            int univ2 = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());
            if (univ[univ1 - 1] != univ[univ2 - 1]) {
                map.add(new node(univ1, univ2, cost));
            }
        }


        Collections.sort(map);

        HashMap<Integer, Integer> group = new HashMap<>();
        int ans = 0;
        int idx = 0;
        int edgeCount = 0;

        for (node edge : map) {
            int x = edge.x;
            int y = edge.y;

            // 둘 다 없음
            if (!group.containsKey(x) && !group.containsKey(y)) {
                group.put(x, idx);
                group.put(y, idx);
                ans += edge.cost;
                idx++;
                edgeCount++;
                continue;
            }

            // 하나만 있음
            if (!group.containsKey(x) || !group.containsKey(y)) {
                if (group.containsKey(x)) {
                    group.put(y, group.get(x));
                } else {
                    group.put(x, group.get(y));
                }
                ans += edge.cost;
                edgeCount++;
                continue;
            }
            //서로 다름
            if (!group.get(x).equals(group.get(y))) {
                int oldGroup = group.get(y);
                int newGroup = group.get(x);


                for (Map.Entry<Integer, Integer> entry : group.entrySet()) {
                    if (entry.getValue() == oldGroup) {
                        entry.setValue(newGroup);
                    }
                }

                ans += edge.cost;
                edgeCount++;
            }
        }

        if (edgeCount == n - 1) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    static class node implements Comparable<node> {
        int x, y, cost;

        public node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return Integer.compare(this.cost, o.cost); // 비용 기준 오름차순
        }
    }
}
