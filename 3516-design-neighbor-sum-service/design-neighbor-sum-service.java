class NeighborSum { 
    public int[][] grid; 
    public int[][] pos; 
    public NeighborSum(int[][] grid) { 
        this.grid = grid; 
        int n = grid.length; 
        this.pos = new int[n * n][2]; 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
                pos[grid[i][j]][0] = i; 
                pos[grid[i][j]][1] = j; 
            } 
        } 
    } 

    public int adjacentSum(int value) { 
        int r = pos[value][0]; 
        int c = pos[value][1]; 
        int sum = 0; 
        int n = grid.length; 
        if (r > 0) sum += grid[r - 1][c]; 
        if (r < n - 1) sum += grid[r + 1][c]; 
        if (c > 0) sum += grid[r][c - 1]; 
        if (c < n - 1) sum += grid[r][c + 1]; 
        return sum; 
    } 

    public int diagonalSum(int value) { 
        int r = pos[value][0]; 
        int c = pos[value][1]; 
        int sum = 0; 
        int n = grid.length; 
        if (r > 0 && c > 0) sum += grid[r - 1][c - 1]; 
        if (r < n - 1 && c < n - 1) sum += grid[r + 1][c + 1]; 
        if (r > 0 && c < n - 1) sum += grid[r - 1][c + 1]; 
        if (r < n - 1 && c > 0) sum += grid[r + 1][c - 1]; 
        return sum; 
    } 
}


/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */