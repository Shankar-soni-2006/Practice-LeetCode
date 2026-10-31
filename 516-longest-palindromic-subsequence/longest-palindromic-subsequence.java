class Solution {
    int[][]dp;
    public int helper(String s, int i, int j){
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return 2+helper(s, i+1, j-1);
        int x = helper(s, i+1, j);
        int y = helper(s, i, j-1);
        return dp[i][j] = Math.max(x, y);
    }
    public int longestPalindromeSubseq(String s) {
        dp = new int [s.length()+1][s.length()+1];
        for(int [] x : dp) Arrays.fill(x, -1);
        return helper(s, 0, s.length()-1);
    }
}