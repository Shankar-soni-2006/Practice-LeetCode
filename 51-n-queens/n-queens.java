class Solution {
    public void helper(List<List<String>> ans, int r, int n, char[][] board, boolean[] col, boolean[] diag1, boolean[] diag2){
        if(r == n){
            List<String> temp = new ArrayList<>();
            for(char[] ri : board) temp.add(new String(ri));
            ans.add(temp);
            return;
        }
        for(int c = 0; c < n; c++){
            int d1 = r-c+n;
            int d2 = r+c;
            if(!col[c] && !diag1[d1] && !diag2[d2]){
                board[r][c] = 'Q';
                col[c] = diag1[d1] = diag2[d2] = true;
                helper(ans, r+1, n, board, col, diag1, diag2);
                board[r][c] = '.';
                col[c] = diag1[d1] = diag2[d2] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n; i++) Arrays.fill(board[i],'.');
        helper(ans, 0, n, board, col, diag1, diag2);
        return ans;
    }
}