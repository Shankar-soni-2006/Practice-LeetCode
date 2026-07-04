class Solution { 
    public int helper(int[] nums, int targetSum, int curr, int idx) {
        if (idx == nums.length) {
            return curr == targetSum ? 1 : 0;
        }
        int x = helper(nums, targetSum, curr + nums[idx], idx + 1);
        int y = helper(nums, targetSum, curr, idx + 1);
        return x+y;
    } 

    public int findTargetSumWays(int[] nums, int target) {
        int totalsum = 0;
        for (int i : nums) totalsum += i;
        if ((totalsum + target) < 0 || (totalsum + target) % 2 != 0 || Math.abs(target) > totalsum) {
            return 0; 
        }
        
        int targetSum = (totalsum + target) / 2;
        return helper(nums, targetSum, 0, 0);
    } 
}
