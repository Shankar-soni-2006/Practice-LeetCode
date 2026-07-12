class Solution {
    public int largestSubmatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int max = 0;
        for(int i = 1;i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j]==1) mat[i][j]+=mat[i-1][j];
            }
        }

        for(int i = 0; i < n; i++){
            int[] curr = mat[i].clone();
            Arrays.sort(curr);
            for(int k = 0; k < m; k++){
                int height = curr[m-k-1];
                int width = k+1;
                max = Math.max(max, height * width);
            }
        }
        return max;
    }
}