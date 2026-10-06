class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int land = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int[] r = {-1, 1, 0,0};
        int[] c = {0, 0, -1, 1};
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) {
                grid[i][0] = 0;
                q.add(new int[]{i, 0});
            }
            if (grid[i][col - 1] == 1) {
                grid[i][col - 1] = 0;
                q.add(new int[]{i, col - 1});
            }
        }
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 1) {
                grid[0][j] = 0;
                q.add(new int[]{0, j});
            }
            if (grid[row - 1][j] == 1) {
                grid[row - 1][j] = 0;
                q.add(new int[]{row - 1, j});
            }
        }
        // if(land == 0) return 0;
        int ans = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = curr[0] + r[k];
                int y = curr[1] + c[k];
                if (x >= 0 && x < row && y >= 0 && y < col &&
                    grid[x][y] == 1) {
                    grid[x][y] = 0;
                    q.add(new int[]{x, y});
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}