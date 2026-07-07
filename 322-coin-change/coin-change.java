class Solution {
    int[][] dp;
    public int helper(int[] coins, int amount, int idx) {
        
        if (amount < 0) return 100000000; 
        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return 100000000;
            }
        }
        if (dp[idx][amount] != -1) return dp[idx][amount]; 
        int take = 1 + helper(coins, amount - coins[idx], idx);
        int notTake = helper(coins, amount, idx - 1);
        return dp[idx][amount] = Math.min(take, notTake);  
    }

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        for(int[] x : dp) Arrays.fill(x,-1);
        Arrays.sort(coins);
        if (amount == 0) {
            return 0;
        }
        int ans = helper(coins, amount, coins.length - 1);
        if (ans >= 100000000) {
            return -1;
        }
        return ans;
    }
}
