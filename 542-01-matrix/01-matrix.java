class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> dq = new ArrayDeque<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    dq.add(new int[]{i,j});
                }
                else mat[i][j] = -1;
            }
        }
        int level = 0;
        int []r = {-1,1,0,0};
        int []c = {0,0,1,-1};
        while(!dq.isEmpty()){
            int s = dq.size();
            for(int i=0;i<s;i++){
                int []temp = dq.poll();
                for(int k=0;k<4;k++){
                    int x = temp[0] + r[k];
                    int y = temp[1] + c[k];
                    if(x>=0 && y>=0 && x<m && y<n && mat[x][y]==-1){
                        mat[x][y] = level+1;
                        dq.add(new int[]{x,y});
                    }
                }
            }
            level++;
        }
        return mat;
    }
}