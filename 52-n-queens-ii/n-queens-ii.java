class Solution {
    static int count = 0;
    public void helper(int r, int n, char[][] queen, boolean[]col, boolean[] diag1, boolean[] diag2){
        if(r==n){
            // List<String> temp = new ArrayList<>();
            // for(char[] ri : queen) temp.add(new String(ri));
            // ans.add(temp);
            count++;
            return;
        }
        for(int c = 0; c < n; c++){
            int d1 = n+r-c;
            int d2 = r+c;
            if(!col[c] && !diag1[d1] && !diag2[d2]){
                queen[r][c] = 'Q';
                col[c] = diag1[d1] = diag2[d2] = true;
                helper(r+1, n, queen, col, diag1, diag2);
                queen[r][c] = '.';
                col[c] = diag1[d1] = diag2[d2] = false;
            }
        }
    }
    public int totalNQueens(int n) {
        // List<List<String>> ans = new ArrayList<>();
        count = 0;
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n*2];
        boolean[] diag2 = new boolean[n*2];
        char[][] queen = new char[n][n];
        helper(0, n,queen, col, diag1, diag2);
        return count;
    }
}