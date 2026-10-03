class Solution {
    public int dfs(char[][]grid, int i, int j, int[] r, int[]c){
        grid[i][j] = '0';
        int n = grid.length;
        int m = grid[0].length;
        for(int k = 0; k < 4; k++){
            int x = i+r[k];
            int y = j+c[k];
            if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == '1'){
                dfs(grid, x, y, r,c);
            }
        }
        return 1;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int[] r = {-1,1,0,0};
        int[] c = {0,0,-1,1};
        for(int i = 0 ;i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1') cnt += dfs(grid, i, j, r, c);
            }
        }
        return cnt;
    }
}