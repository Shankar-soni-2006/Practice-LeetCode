class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(solve(nums, 0, n - 2),solve(nums, 1, n - 1));
    }
    public int solve(int[] nums, int start, int end) {
        int y = 0;
        int x = 0;
        for (int i = start; i <= end; i++) {
            int rob = nums[i] + y;
            int notRob = x;
            int curr = Math.max(rob, notRob);
            y = x;
            x = curr;
        }
        return x;  
    }
}
