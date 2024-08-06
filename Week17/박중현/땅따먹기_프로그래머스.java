class Solution {
	int solution(int[][] land) {
		int answer = 0;

		// 땅따먹기
		// 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있다.
		// 1행부터 땅을 밟으며 한 행씩 내려올 때 각 행의 4칸 중 한 칸만 밟으면서 내려와야 한다.

		// 1 2 3 |5|
		// 5 6 7 8
		// 4 3 2 1
		// 로 땅이 주어졌다면, 1행에서 네 번째 칸(5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없다.

		int[][] dp = new int[land.length][4];

		for(int i = 0; i < 4; i++) {
			dp[0][i] = land[0][i];
		}

		for(int i = 1; i < land.length; i++) {
			dp[i][0] = Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][0];
			dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3])) + land[i][1];
			dp[i][2] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3])) + land[i][2];
			dp[i][3] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + land[i][3];
		}

		for(int i = 0; i < 4; i++) {
			answer = Math.max(dp[land.length-1][i], answer);
		}

		return answer;
	}
}