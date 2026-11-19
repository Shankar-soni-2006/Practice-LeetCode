class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[]dp = new int[m];
        dp[0] = grid[0][0];
        for(int i = 1; i < m; i++) dp[i] = dp[i-1] +grid[0][i];
        for(int i =1 ;i < n; i++){
                dp[0] = dp[0] + grid[i][0];
            for(int j = 1; j < m; j++){
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j-1]);
            }
        }
        return dp[m-1];
    }
}