
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int[] cnt = new int[30];
        for (int num : nums) {
            long power = 1;
            for (int i = 0; i < 30; i++) {
                if ((num / power) % 2 == 1) {
                    cnt[i]++;
                }
                power *= 2;
            }
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            long x = 0;
            long power = 1;
            for (int j= 0; j< 30; j++) {
                if (cnt[j] > 0) {
                    x += power;
                    cnt[j]--;
                }
                power *= 2;
            }
            ans = (ans + x * x) % MOD;
        }
        return (int) ans;
    }
}
