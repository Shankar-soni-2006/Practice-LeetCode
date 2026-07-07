class Solution {
    public boolean valid(char[][]board, int r, int c, int digit){
        for(int i = 0; i < 9; i++){
            if(board[r][i] == digit) return false;
        }
        for(int i = 0; i < 9; i++){
            if(board[i][c] == digit) return false;
        }
        int sr = (r/3) * 3;
        int sc = (c/3) * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[sr+i][sc+j] == digit) return false;
            }
        }
        return true;
    }
    public boolean solve(char[][] board){
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.'){
                    for(char i = '1'; i <='9'; i++){
                        if(valid(board, r, c, i)){
                            board[r][c] = i;
                            if(solve(board)) return true;
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}