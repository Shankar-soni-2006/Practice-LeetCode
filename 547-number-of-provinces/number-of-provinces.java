class DSU {
    int n;
    int[] par;
    int[] size;
    DSU(int n) {
        this.n = n;
        par = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }
    }
    int find(int x) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x]);
    }
    void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b)
            return;
        if (size[a] < size[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        par[b] = a;
        size[a] += size[b];
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU d = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1)
                    d.union(i, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == d.find(i))
                ans++;
        }
        return ans;
    }
}