class Solution {
    public int countIslands(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] > 0) {
                    int rem = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{r, c});
                    rem = (rem + grid[r][c]) % k;
                    grid[r][c] = -1; 
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int currR = curr[0];
                        int currC = curr[1];
                        for (int[] dir : directions) {
                            int nr = currR + dir[0];
                            int nc = currC + dir[1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                                rem = (rem + grid[nr][nc]) % k;
                                grid[nr][nc] = -1;
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    if (rem == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}