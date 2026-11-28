class Solution {
    int[] dp;
    int recursive(int idx, int[] arr, int n, int k){
        if(idx ==  n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int l = 0;
        int num = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for(int i = idx; i < Math.min(n, idx+k); i++){
            l++;
            num = Math.max(num, arr[i]);
            int curr = l * num + recursive(i+1, arr, n, k);
            sum = Math.max(sum, curr);
        }
        return dp[idx] = sum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recursive(0, arr, n, k);
    }
}