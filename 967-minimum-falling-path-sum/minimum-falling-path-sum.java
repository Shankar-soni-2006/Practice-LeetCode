class Solution {
    int[][] dp;

    public int helper(int i, int j, int[][] grid, int m, int n) {
        if (j < 0 || j >= m) return 100000000;
        if (i == n - 1) return grid[i][j];
        if (dp[i][j] != 1000000000) return dp[i][j];

        int d = helper(i + 1, j - 1, grid, m, n);
        int r = helper(i + 1, j, grid, m, n);
        int l = helper(i + 1, j + 1, grid, m, n);
        return dp[i][j] = grid[i][j] + Math.min(d, Math.min(l, r));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        dp = new int[n][m];
        for (int[] x : dp) {
            Arrays.fill(x, 1000000000);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, helper(0, j, matrix, m, n));
        }
        return ans;
    }
}
