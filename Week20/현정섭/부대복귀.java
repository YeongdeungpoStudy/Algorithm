import java.util.*;

public class 부대복귀 {
    
    private static class Node{
        int dest, cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int start = destination;
        
        ArrayList<Node>[] adjList = new ArrayList[n+1];

        for(int i = 0; i < n+1; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : roads){
            adjList[edge[0]].add(new Node(edge[1], 1));
            adjList[edge[1]].add(new Node(edge[0], 1));
        }

        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.dest] < now.cost){
                continue;
            }

            for(Node next : adjList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost){
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, now.cost + next.cost));

                }
            }   

        }
        
        for(int source : sources){
            if(dist[source] == Integer.MAX_VALUE){
                answer.add(-1);
            }
            else{
                answer.add(dist[source]);
            }
                
        }
        
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
