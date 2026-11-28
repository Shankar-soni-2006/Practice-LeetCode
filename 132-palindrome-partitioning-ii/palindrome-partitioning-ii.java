class Solution {
    boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for(int j = i; j < n; j++) {
                if(isPalindrome(s, i, j)) {
                    int x = 1 + dp[j + 1];
                    min = Math.min(min, x);
                }
            }
            dp[i] = min;
        }
        return dp[0] - 1;
    }
}