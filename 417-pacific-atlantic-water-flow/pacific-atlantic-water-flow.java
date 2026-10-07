class Solution {
    public void dfs(int r, int c, int x, int prev, int[][] heights, int[][] temp){
        int rows = heights.length;
        int cols = heights[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || heights[r][c] < prev) return;
        int curr = temp[r][c];
        if (curr == 3 || curr == x) return;
        if (curr == 0) {
            temp[r][c] = x;
        } else if (curr != x) {
            temp[r][c] = 3;
        }
        dfs(r + 1, c, x, heights[r][c], heights, temp);
        dfs(r - 1, c, x, heights[r][c], heights, temp);
        dfs(r, c + 1, x, heights[r][c], heights, temp);
        dfs(r, c - 1, x, heights[r][c], heights, temp);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        // if (heights == null || heights.length == 0 || heights[0].length == 0) return ans;
        int row = heights.length;
        int col = heights[0].length;
        int[][] temp = new int[row][col];
        for(int i = 0; i < col; i++){
            dfs(0, i, 1, heights[0][i], heights, temp);
            dfs(row - 1, i, 2, heights[row - 1][i], heights, temp);
        }
        for(int i = 0; i < row; i++){
            dfs(i, 0, 1, heights[i][0], heights, temp);
            dfs(i, col - 1, 2, heights[i][col - 1], heights, temp);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(temp[i][j] == 3){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    ans.add(ls);
                }
            }
        }
        return ans;
    }
}
