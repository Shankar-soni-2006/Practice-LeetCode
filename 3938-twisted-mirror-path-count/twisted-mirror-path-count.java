class Solution {
    int[][] dp;
    int mod = ((int)1e9)+7;
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int []x:dp) Arrays.fill(x,-1);
        return dfs(grid,0,0,-1);
    }
    int dfs(int[][] grid,int i,int j,int prev){
        while(i<grid.length && j<grid[0].length && grid[i][j]==1){
            if(prev==0){
                i++;
                prev=1;
            }
            else if(prev==1){
                j++;
                prev = 0;
            }
        }
        if(i==grid.length-1 && j==grid[0].length-1) return 1;
        if(i>=grid.length || j>=grid[0].length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int x = dfs(grid,i,j+1,0);
        int y = dfs(grid,i+1,j,1);
        return dp[i][j] = (x+y)%mod;
    }
}