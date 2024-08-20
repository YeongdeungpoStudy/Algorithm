package Week19.권우현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 네트워크_연결 {
    static ArrayList<computer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer str;
        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            list.add(new computer(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken())));
        }


        Collections.sort(list);

        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for (computer c : list) {
            if (find(c.s, parent) != find(c.e, parent)) {
                union(c.s, c.e, parent);
                ans += c.cost;
            }
        }

        System.out.println(ans);

    }

    private static int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    private static void union(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }



    static class computer implements Comparable<computer> {
        int s;
        int e;
        int cost;

        public computer(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }


        @Override
        public int compareTo(computer o) {
            return this.cost - o.cost;
        }
    }
}
