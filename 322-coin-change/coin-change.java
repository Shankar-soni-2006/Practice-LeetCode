class Solution{
    int[][] dp;
    public int helper(int[] coins, int amt, int idx){
        if(amt < 0 ) return (int)1e8;
        if(idx == 0){
            if(amt % coins[0] == 0) return amt/ coins[0];
            else return (int)1e8;
        }
        if(dp[idx][amt] != -1) return dp[idx][amt];
        int x = 1 + helper(coins, amt - coins[idx], idx);
        int y = helper(coins, amt, idx-1);
        return dp[idx][amt] = Math.min(x, y);
    }

    public int coinChange(int[] coins, int amt){
        dp = new int[coins.length][amt+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        Arrays.sort(coins);
        if(amt == 0) return 0;
        int ans = helper(coins, amt, coins.length-1);
        if(ans >= (int)1e8) return -1;
        return ans;
    }
}
