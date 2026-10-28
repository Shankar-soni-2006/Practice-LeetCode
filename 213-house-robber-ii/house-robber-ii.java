class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int a = 0, b = 0;
        for (int i = 0; i < n - 1; i++) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        int x = b;
        a = 0;
        b = 0;
        for (int i = 1; i < n; i++) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        int y = b;
        return Math.max(x, y);
    }
}