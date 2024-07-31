import java.io.BufferedReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] wine;
    static int[] dp;

	public static void main(String[] args) throws Exception {
		input();
        process();
	}

    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        wine = new int[N+1];
        for(int i=1; i<=N; i++)
            wine[i] = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[1] = wine[1];
    }

    static void process() {
        // N=1의 경우를 대비해 예외처리 
        if(N > 1)
            dp[2] = wine[1] + wine[2];

        // 전 와인과 전전 와인을 먹을 수 있는 3번째 와인부터 시작 
        for(int i = 3; i < n+1; i++) { 
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + wine[i-1]) + wine[i]); 
		}
		
		System.out.println(dp[n]);
    }

}