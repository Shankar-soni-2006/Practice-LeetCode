class Solution {
    public boolean dfs(char[][] board, int r, int c, int idx, String word){
        if(idx == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(idx)) return false;
        char val = board[r][c];
        board[r][c] = '@';
        boolean found = dfs(board, r-1, c, idx+1, word) ||
                        dfs(board, r+1, c, idx+1, word) ||
                        dfs(board, r, c+1, idx+1, word) ||
                        dfs(board, r, c-1, idx+1, word);
        board[r][c] = val;
        return found;    
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, i, j ,0, word)) return true;
            }
        }
        return false;
    }
}