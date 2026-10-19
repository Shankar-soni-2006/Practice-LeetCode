class Solution {
    public boolean dfs(int[][] grid, boolean[][] vis, int mid, int i, int j){
        int n = grid.length, m = grid[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] > mid) return false;
        if(i == n - 1 && j == m - 1) return true;
        vis[i][j] = true;
        boolean down  = dfs(grid, vis, mid, i + 1, j);
        boolean up  = dfs(grid, vis, mid, i - 1, j);
        boolean right = dfs(grid, vis, mid, i, j + 1);
        boolean left  = dfs(grid, vis, mid, i, j - 1);
        return down || up || right || left;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = grid[0][0];
        int r = (int)1e6;
        int ans = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean[][] vis = new boolean[n][n];
            if (dfs(grid, vis, mid, 0, 0)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
