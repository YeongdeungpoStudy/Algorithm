class Solution {
    int solution(int[][] land) {
        int N = land.length;
        
        int[][] dp = new int[N][4];
        
        //initialized 
        for(int i =0;i<4;i++){
            dp[0][i] = land[0][i];
        }
        
        //dp
        for(int i=1;i<N;i++){
            for(int j=0;j<4;j++){
                int max = Integer.MIN_VALUE;
                for(int k=0;k<4;k++){
                    if(j==k){
                        continue;
                    }
                    
                    if(max < dp[i-1][k]){
                        max = dp[i-1][k];
                    }
                }
                
                dp[i][j] = max + land[i][j];
            }
        }
        
        int res = Integer.MIN_VALUE;
        for(int i=0;i<4;i++){
            if(res < dp[N-1][i]){
                res = dp[N-1][i];
            }
        }
    
        return res;
    }
}
