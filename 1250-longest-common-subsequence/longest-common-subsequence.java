class Solution {
    int[][]dp;
    public int helper(String x, String y, int i, int j, int[][]dp){
        if(i == x.length() || j == y.length()){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(x.charAt(i) == y.charAt(j)){
            return 1+helper(x, y, i+1, j+1, dp);
        }
        int a = helper(x, y, i+1, j, dp);
        int b = helper(x, y, i, j+1, dp);
        return dp[i][j] = Math.max(a, b);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()];
        for(int[] x : dp) Arrays.fill(x, -1);
        return helper(text1, text2, 0, 0, dp);
    }
}