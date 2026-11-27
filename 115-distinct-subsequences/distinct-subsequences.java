class Solution {
    int[][] dp;
    int helper(String s, String t, int i, int j){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == t.charAt(j)){
            int ta = helper(s, t, i+1, j+1);
            int nt = helper(s, t, i+1, j);
            ans = nt + ta;
        } else ans = helper(s, t, i+1, j);
        return dp[i][j] = ans;
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        dp = new int[m + 1][n + 1];
        for(int[] x : dp) Arrays.fill(x, -1);
        return helper(s, t, 0, 0);
    }
}
