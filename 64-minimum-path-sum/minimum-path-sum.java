class Solution {
    int[][] dp;
    public int helper(int i, int j, int[][] grid, int m, int n) {
        if (i >= m || j >= n)  return Integer.MAX_VALUE;
        if (i == m - 1 && j == n - 1) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];
        int d = helper(i + 1, j, grid, m, n);
        int r = helper(i, j + 1, grid, m, n);
        dp[i][j] = grid[i][j] + Math.min(d, r);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return helper(0, 0, grid, m, n);
    }
}
