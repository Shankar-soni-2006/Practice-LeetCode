class Solution {
    int[] arr;
    int find(int x){
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        arr = new int[n+1];
        for(int i = 1; i <=n; i++){
            arr[i] = i;
        }
        for(int i = 0; i < n; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int nu = find(u);
            int nv = find(v);
            if(nu == nv) return new int[]{u,v};
            arr[nu] = nv;
        }
        return new int[]{};
    }
}