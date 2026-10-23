class DSU{
    int n;
    int[] par;
    int[] size;

    DSU(int n){
        this.n = n;
        par = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            par[i] = i;
            size[i] = 1;
        }
    }

    int find(int x){
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if(a == b) return;

        if(size[a] < size[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        par[b] = a;
        size[a] += size[b];
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        DSU d = new DSU(n);
        for(int i = 0; i < connections.length; i++) {
            d.union(connections[i][0], connections[i][1]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(d.find(i) == i) {
                ans++;
            }
        }
        return ans - 1;
    }
}