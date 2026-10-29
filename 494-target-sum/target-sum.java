class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum < Math.abs(target)) return 0;
        if((sum + target) % 2 != 0) return 0;
        int tar = (sum + target) /2;
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int x : nums){
            for(int j = tar; j >= x; j--){
                dp[j] += dp[j-x];
            }
        }
        return dp[tar];
    }
}