class Solution {
    public long countPairs(int[] nums, int k){
        long count = 0;
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            if(nums[l]+nums[r] <= k){
                count+=(r - l);
                l++;
            }else r--;
        }
        return count;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairs(nums, upper) - countPairs(nums, lower-1);
    }
}