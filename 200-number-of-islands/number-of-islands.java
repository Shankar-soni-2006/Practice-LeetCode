class DSU{
    int[] par;
    int[] size;
    int n;
    DSU(int n){
        this.n = n;
        par = new int[n];
        size = new int[n];
        for(int i = 0 ;i< n; i++){
            par[i] = i;
            size[i] = 1;
        }
    }
    int find(int x){
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }
    boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py) return false;
        if (size[px] < size[py]) {
            int temp = px;
            px = py;
            py = temp;
        }
        par[py] = px;
        size[px] += size[py];
        return true;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        DSU dsu = new DSU(n*m);
        int[] dr = {1,0};
        int[] dc = {0,1};
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != '1') continue;
                cnt++;
                for(int k = 0; k < 2; k++){
                    int x = i + dr[k];
                    int y = j + dc[k];
                    if(x < n && y < m && grid[x][y] == '1'){
                        if(dsu.union(i*m+j,  x*m+y)) cnt--;
                    }
                }
            }
        }
        return cnt;
    }
}