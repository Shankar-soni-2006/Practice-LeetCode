class Solution {
    public int helper(int[] nums, int l , int r){
        if(l == r) return nums[l];
        return Math.max(nums[l] - helper(nums,l+1,r), nums[r] - helper(nums,l,r-1));
    }
    public boolean predictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1) >= 0;
    }
}