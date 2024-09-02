package Week21.현정섭;
import java.io.*;
import java.util.*;

class 해킹{

    private static class Node{
        int dest, time;

        public Node(int dest, int time){
            this.dest = dest;
            this.time = time;
        }

    }

    public static int[] djkstra(int start, ArrayList<Node>[] adjList, int n){
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(dist[now.dest] < now.time){
                continue;
            }

            for(Node next : adjList[now.dest]){
                if(dist[next.dest] > now.time + next.time){
                    dist[next.dest] = now.time + next.time;
                    pq.add(new Node(next.dest, now.time + next.time));

                }
            }   

        }

        return dist;


    }
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int tcCnt = Integer.parseInt(br.readLine());

        //태케마다 컴퓨터 개수 n, 의존성 개수 d, 해킹당한 컴퓨터의 번호 c 얻어 ArrayList에 넣기
        for(int i = 0; i < tcCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ArrayList<Node>[] adjList = new ArrayList[n+1];

            //ArrayList 초기화
            for(int j = 0; j < n+1; j++){
                adjList[j] = new ArrayList<>();
            }

            //의존성 데이터 얻어 인접리스트에 넣기
            for(int k = 0; k < d; k++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                int t = Integer.parseInt(st2.nextToken());

                adjList[b].add(new Node(a, t));
                //adjList[b].add(new Node(a, t));
                
            }

            //다익스트라 함수
            int[] dist = djkstra(c, adjList, n);
            
            int answer1 = 0;
            int answer2 = 0;

            //dist 돌면서 총 감염되는 컴퓨터 수(MAX_VALUE 아닌 것 + 1), 마지막 컴퓨터가 감염되기까지 걸리는 시간(최대값 로직) 얻기
            for(int distValue : dist){
                if(distValue != Integer.MAX_VALUE){
                    answer1 += 1;

                    if(distValue > answer2){
                        answer2 = distValue;
                    }

                }
  
            }
            //answer 출력
            System.out.println(answer1 + " " + answer2);

        }

    }
    
}