package Week30.권우현;

import java.io.*;
import java.util.*;

public class 별자리_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        node[] stars = new node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new node(x, y);
        }

        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double cost = distance(stars[i], stars[j]);
                graph[i].add(new Edge(j, cost));
                graph[j].add(new Edge(i, cost));
            }
        }


        System.out.printf("%.2f", prim(graph, n));
    }


    static class node {
        double x, y;

        public node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        double cost;

        public Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }


    private static double distance(node n1, node n2) {
        return Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
    }


    private static double prim(List<Edge>[] graph, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        pq.add(new Edge(0, 0.0));

        double totalCost = 0.0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            Edge current = pq.poll();

            if (visited[current.to]) continue;

            visited[current.to] = true;
            totalCost += current.cost;
            count++;

            for (Edge next : graph[current.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        return totalCost;
    }
}
