class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int mn = matrix[i - 1][j];
                if (j > 0) {
                    mn = Math.min(mn, matrix[i - 1][j - 1]);
                }
                if (j < m - 1) {
                    mn = Math.min(mn, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += mn;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, matrix[n - 1][j]);
        }
        return ans;
    }
}
