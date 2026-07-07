class Solution {
    int[][] dp;
    public int helper(int[] coins, int amount, int idx) {
        if (amount == 0) return 1;
        if(amount < 0 || idx < 0) return 0; 
        if (dp[idx][amount] != -1) return dp[idx][amount]; 
        int take = helper(coins, amount - coins[idx], idx);
        int notTake = helper(coins, amount, idx - 1);
        return dp[idx][amount] = take+notTake;  
    }
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins.length == 0) return 0;
        dp = new int[coins.length][amount+1];
        for(int[] x : dp) Arrays.fill(x,-1);
        Arrays.sort(coins);
        int ans =helper(coins, amount, coins.length - 1);
        System.gc();
        return ans;
    }
}