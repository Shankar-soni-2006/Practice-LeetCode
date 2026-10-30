class Solution {
    int[][] dp;
    public int solve(int[] nums, int idx, int prev){
        if(idx == nums.length){
            return 0;
        }
        if (dp[idx][prev + 1] != -1) return dp[idx][prev + 1];
        
        int nt = solve(nums, idx+1, prev);
        int t = 0;
         if (prev == -1 || nums[idx] > nums[prev]) {
            t = 1 + solve(nums, idx + 1, idx);
        }
        return dp[idx][prev+1] = Math.max(nt, t);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return solve(nums, 0, -1);
    }
}