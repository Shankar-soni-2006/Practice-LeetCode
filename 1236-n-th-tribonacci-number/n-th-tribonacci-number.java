class Solution {
    int dp[];
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        dp=  new int[n+1];
        Arrays.fill(dp,-1);
        helper(n);
        return dp[n];
    }
    int helper(int n){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        if(n==1 || n==2) return 1;
        return dp[n] = helper(n-1)+helper(n-2)+helper(n-3);
    }
}