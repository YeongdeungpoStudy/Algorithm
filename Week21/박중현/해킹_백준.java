import java.io.*;
import java.util.*;

public class Main {

	static List<Computer>[] arr;
	static int dist[];
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// yum3이 네트워크 시설의 한 컴퓨터를 해킹했다. 이제 서로에 의존하는 컴퓨터 들은 점차 하나둘 전염되기 시작
		// 어떤 컴퓨터 a가 다른 컴퓨터 b에 의존한다면 b가 감염되면 그로부터 일정 시간 뒤 a도 감염

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 전체 컴퓨터 개수
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

			arr = new ArrayList[n+1];
			dist = new int[n+1];
			visit = new boolean[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);

			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				// a는 b 에 의존 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨\
				// b에서 a로 갈 수 있다.
				// arr[b] = new ArrayList<>();
				if (arr[b] == null) {
					arr[b] = new ArrayList<>();
				}

				arr[b].add(new Computer(a,s));
			}

			// c : 출발지 , 도착지는 미정
			dijkstra(c);

			int count = 0;
			int time = 0;

			for (int k = 1; k <= n; k++) {
				if (dist[k] == Integer.MAX_VALUE) {
					continue;
				}

				count++;
				time = Math.max(time, dist[k]);
			}

			bw.write(count+ " " + time+ "\n");

		}

		br.close();
		bw.close();
	}

	public static void dijkstra(int c) {

		PriorityQueue<Computer> pq = new PriorityQueue<>();

		pq.add(new Computer(c, 0));

		dist[c] = 0;

		while (!pq.isEmpty()) {
			Computer currentComputer = pq.poll();
			int computerNow = currentComputer.now;

			if (visit[computerNow]) {
				continue;
			}

			visit[computerNow] = true;

			if (arr[computerNow] == null) {
				continue;
			}

			for (int i = 0; i < arr[computerNow].size(); i++) {
				Computer nextComputer = arr[computerNow].get(i);

				if (dist[computerNow] + nextComputer.time < dist[nextComputer.now]) {
					dist[nextComputer.now] = dist[computerNow] + nextComputer.time;
					pq.add(new Computer(nextComputer.now, dist[nextComputer.now]));
				}
			}

		}
	}
}

class Computer implements Comparable<Computer> {
	int now;
	int time;

	public Computer(int now, int time) {
		this.now = now;
		this.time = time;
	}

	@Override
	public int compareTo(Computer other) {
		return this.time - other.time;
	}
}