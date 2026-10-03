class Solution {

    // USING BFS
     public int bfs(char[][] grid, boolean[][] vis, Queue<int[]> q, int i, int j, int[] r, int[] c) {
        vis[i][j] = true;
        q.add(new int[] { i, j });
        int n = grid.length;
        int m = grid[0].length;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i1 = 0; i1 < s; i1++) {
                int[] curr = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = curr[0] + r[k];
                    int y = curr[1] + c[k];
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == '1' && !vis[x][y]) {
                        vis[x][y] = true;
                        q.add(new int[] { x, y });
                    }
                }
            }
        }
        return 1;
    }
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        int[] r = { -1, 1, 0, 0 };
        int[] c = { 0, 0, -1, 1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    cnt += bfs(grid, vis, q, i, j, r, c);
                }
            }
        }
        return cnt;
    }

   
}