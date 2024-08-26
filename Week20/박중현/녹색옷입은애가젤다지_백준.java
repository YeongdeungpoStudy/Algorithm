import java.awt.*;
import java.io.*;
import java.util.*;
public class Main {

	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 녹색 옷 입은 애가 젤다지?
		// 젤다의 전설 게임에서 화폐의 단위는 루피다.
		// 그런데 간혹 도둑루피라 불리는 검정색 루피도 존재하는데, 이걸 획득하면 소지한 루피가 감소한다.
		StringBuilder sb = new StringBuilder();

		int idx = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			arr = new int[N][N];

			for (int i = 0; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int totalReducedRupee = bfs(N);

			sb.append("Problem " + idx + ": " + totalReducedRupee + "\n");
			idx++;

		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	public static int bfs(int length) {
		Cave startCave = new Cave(0, 0, arr[0][0]);
		Queue<Cave> queue = new PriorityQueue<>();
		queue.add(startCave);

		int[][] dist = new int[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		dist[0][0] = arr[0][0];

		while (!queue.isEmpty()) {

			Cave polledCave = queue.poll();

			// if (polledCave.x == length -1 && polledCave.y == length -1) {
			//     return dist[length-1][length-1];
			// }

			for (int i = 0; i < 4; i++) {
				int nx = polledCave.x + dx[i];
				int ny = polledCave.y + dy[i];
				int reducedRupee = polledCave.reducedRupee;


				if (nx < 0 || ny < 0 || nx >= length || ny >= length) {
					continue;
				}

				if (dist[nx][ny] > reducedRupee + arr[nx][ny]) {
					dist[nx][ny] = reducedRupee + arr[nx][ny];
					queue.add(new Cave(nx, ny, polledCave.reducedRupee + arr[nx][ny]));
				}
			}
		}

		return dist[length-1][length-1];
		// return -1;
	}
}

class Cave implements Comparable<Cave>{
	int x;
	int y;
	int reducedRupee;

	public Cave(int x, int y, int reducedRupee) {
		this.x = x;
		this.y = y;
		this.reducedRupee = reducedRupee;
	}

	@Override
	public int compareTo(Cave other) {
		if (this.reducedRupee <= other.reducedRupee) {
			return -1;
		}

		return 1;
	}
}
