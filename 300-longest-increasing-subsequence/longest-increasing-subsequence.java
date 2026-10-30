class Solution {
    int[] dp;
    int helper(int n,int[] nums){
        int ans = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        return helper(n,nums);
    }
}