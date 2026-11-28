class Solution {
    int[][] dp;
    boolean isPalindrome(String s, int st, int e) {
        while(st < e) {
            if(s.charAt(st) != s.charAt(e)) return false;
            st++;
            e--;
        }
        return true;
    }
    int helper(String s, int st, int e) {
        if(st > e) return 0;
        if(dp[st][e] != -1) return dp[st][e];
        int min = Integer.MAX_VALUE;
        for(int i = st; i <= e; i++) {
            if(isPalindrome(s, st, i)) {
                int x = 1 + helper(s, i + 1, e);
                min = Math.min(min, x);
            }
        }
        return dp[st][e] = min;
    }

    public int minCut(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] x : dp) Arrays.fill(x, -1);
        return helper(s, 0, n - 1) - 1;
    }
}