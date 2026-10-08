class Solution {
    int[] parent;
    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] first = null;
        int[] second = null;
        int[] parentNode = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parentNode[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (parentNode[v] != v) {
                first = new int[]{parentNode[v], v};
                second = new int[]{u, v};
                edge[0] = -1;
                edge[1] = -1;
            } else {
                parentNode[v] = u;
            }
        }
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[0] == -1) continue;
            int u = edge[0];
            int v = edge[1];
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) {
                if (first == null) return new int[]{u, v};
                return first;
            }
            parent[pu] = pv;
        }
        return second;
    }
}