package Week21.현정섭;
import java.io.*;
import java.util.*;

public class 합승 {

    
    class Solution {
        
        private static class Node{
            
            int dest, cost;
            
            public Node(int dest, int cost){
                this.dest = dest;
                this.cost = cost;
            }
            
        }
        
        public static int[] djkstra(int start, ArrayList<Node>[] adjList, int n, int[] dist){
            
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
    
            return dist;
    
    
        }
        
        //public static final int[] dist;
        
        public int solution(int n, int s, int a, int b, int[][] fares) {
            
            int answer = 0;
            
            
            ArrayList<Node>[] adjList = new ArrayList[n+1];
            
            for(int i = 0; i < n+1; i++){
                adjList[i] = new ArrayList<>();
            }
            
            for(int i = 0; i < fares.length; i++){    
                adjList[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
                adjList[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
            }
            
            int[] tgDist = new int[n+1];
            
            Arrays.fill(tgDist, Integer.MAX_VALUE);
            
            tgDist =  djkstra(s, adjList, n, tgDist);
            
            int[] ADist = new int[n+1];
            
            Arrays.fill(ADist, Integer.MAX_VALUE);
            
            ADist =  djkstra(a, adjList, n, ADist);
            
            int[] BDist = new int[n+1];
            
            Arrays.fill(BDist, Integer.MAX_VALUE);
            
            BDist =  djkstra(b, adjList, n, BDist);
            
            int min = Integer.MAX_VALUE;
            
            // System.out.println(Arrays.toString(tgDist));
            // System.out.println(Arrays.toString(ADist));
            // System.out.println(Arrays.toString(BDist));
            
            
            
            for(int i = 1; i < n+1; i++){
                int c = BDist[i] + ADist[i] + tgDist[i];
                if(min > c){
                    min = c;
                }
            }
            
            //System.out.println(min);
            
            return min;
        }
    }
}
