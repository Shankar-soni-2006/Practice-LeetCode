// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) return nums[0];
//         int a = 0, b = 0;
//         for (int i = 0; i < n - 1; i++) {
//             int c = Math.max(nums[i] + a, b);
//             a = b;
//             b = c;
//         }
//         int x = b;
//         a = 0;
//         b = 0;
//         for (int i = 1; i < n; i++) {
//             int c = Math.max(nums[i] + a, b);
//             a = b;
//             b = c;
//         }
//         int y = b;
//         return Math.max(x, y);
//     }
// }

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
