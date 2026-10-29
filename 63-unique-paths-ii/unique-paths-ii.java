class Solution {
    int[][] dp;
    public int helper(int i, int j, int m, int n, int[][] ob) {
        if (i >= m || j >= n || ob[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = helper(i + 1, j, m, n, ob) + helper(i, j + 1, m, n, ob);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] ob) {
        int m = ob.length, n = ob[0].length;
        dp = new int[m][n];
        for (int k = 0; k < m; k++) {
            Arrays.fill(dp[k], -1);
        }
        return helper(0, 0, m, n, ob);
    }
}