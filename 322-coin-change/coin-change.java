class Solution {
    public int coinChange(int[] coins, int amt) {
        if(amt == 0) return 0;
        int n = coins.length;
        int INF = (int)1e8;
        int[][] dp = new int[n][amt+1];
        for(int i = 0; i <= amt; i++){
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = INF;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= amt; j++){
                int nt = dp[i-1][j];
                int t = INF;
                if(coins[i] <= j) t = 1+ dp[i][j-coins[i]];
                dp[i][j] = Math.min(nt, t);
            }
        }
        return dp[n-1][amt] >= INF ? -1 : dp[n-1][amt];
    }
}