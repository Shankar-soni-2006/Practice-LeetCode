class Solution {
    int[][] dp;
    public int helper(int[] coins, int amt, int idx){
        if(amt == 0) return 1;
        if(amt < 0 || idx < 0) return 0;
        if(dp[idx][amt] != -1) return dp[idx][amt];
        int x = helper(coins, amt-coins[idx], idx);
        int y = helper(coins, amt, idx-1);
        return dp[idx][amt] = x+y;
    }
    public int change(int amt, int[] coins){
        if(amt == 0) return 1;
        if(coins.length == 0) return 0;
        dp = new int[coins.length][amt+1];
        for(int[] x : dp) Arrays.fill(x, -1);
        Arrays.sort(coins);
        int ans = helper(coins, amt, coins.length-1);
        return ans;
    }
}