class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int st = -1, e = -2;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) e = i;
        }
        for(int i = n-1; i >= 0; i--){
            min = Math.min(min,nums[i]);
            if(nums[i] > min) st = i;
        }
        return e-st+1;
    }
}