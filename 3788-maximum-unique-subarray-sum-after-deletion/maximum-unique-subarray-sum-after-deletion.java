class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 1];
        if (max <= 0) {
            return max;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    sum += nums[i];
                }
            }
        }
        return sum;
    }
}
