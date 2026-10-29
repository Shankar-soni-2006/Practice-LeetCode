class Solution {
    public int change(int amt, int[] coins) {
        int[] dp = new int[amt+1];
        dp[0] = 1;
        for(int x : coins){
            for(int j = x; j <= amt; j++){
                dp[j]+=dp[j-x];
            }
        }
        return dp[amt];
    }
}