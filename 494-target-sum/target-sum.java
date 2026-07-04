class Solution {
    static int count = 0;
    public void helper(int[] nums, int target, int sum, int idx){
        // if(sum == target){
        //     count++;
        //     return;
        // }
        if(idx == nums.length){
            if(sum==target){
                count++;
            }
            return;
        } 
        // sum = sum + (2 * nums[idx]);
        helper(nums, target, sum+nums[idx],idx+1);
        helper(nums, target, sum-nums[idx],idx+1);
        // sum = sum - (2 * nums[idx]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        count = 0;
        // for(int i : nums) sum+=i;
        helper(nums,target,sum,0);
        return count;
    }
}