class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int total = m*n;
        k%=total;
        for(int i = 0; i < m; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                int idx =(i * n + j-k+total)%total;
                int newRow = idx/n;
                int newCol = idx%n;
                temp.add(grid[newRow][newCol]);
            }
            res.add(temp);
        }
        return res;
    }
}