
import java.util.Arrays;

class Solution {
    int[][] dp;
    public int helper(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = helper(i + 1, j, m, n) + helper(i, j + 1, m, n);

        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for (int k = 0; k < m; k++) {
            Arrays.fill(dp[k], -1);
        }
        return helper(0, 0, m, n);
    }
}
