class Solution {
    public boolean dfs(int[][] grid, boolean[][] vis, int k, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        if (i == n - 1 && j == m - 1) return true;
        if (vis[i][j]) return false;
        vis[i][j] = true;
        boolean f1 = false, f2 = false, f3 = false, f4 = false;
        if (i + 1 < n && Math.abs(grid[i][j] - grid[i + 1][j]) <= k)
            f1 = dfs(grid, vis, k, i + 1, j);

        if (j + 1 < m && Math.abs(grid[i][j] - grid[i][j + 1]) <= k)
            f2 = dfs(grid, vis, k, i, j + 1);

        if (i - 1 >= 0 && Math.abs(grid[i][j] - grid[i - 1][j]) <= k)
            f3 = dfs(grid, vis, k, i - 1, j);

        if (j - 1 >= 0 && Math.abs(grid[i][j] - grid[i][j - 1]) <= k)
            f4 = dfs(grid, vis, k, i, j - 1);

        return f1 || f2 || f3 || f4;
    }
    public int minimumEffortPath(int[][] heights) {
        int l = 0;
        int r = 1_000_000; 
        int ans = 1_000_000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean[][] vis = new boolean[heights.length][heights[0].length];
            if (dfs(heights, vis, mid, 0, 0)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
