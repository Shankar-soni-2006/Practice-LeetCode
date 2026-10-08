class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (dfs(graph, i, -1, 0, vis, depth)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph, int node, int parent, int curr, boolean[] vis, int[] depth) {
        vis[node] = true;
        depth[node] = curr;
        for (int nbr : graph[node]) {
            if (nbr == parent) {
                continue;
            }
            if (!vis[nbr]) {
                if (dfs(graph, nbr, node, curr + 1, vis, depth)) {
                    return true;
                }
            } else {
                int cyclen = Math.abs(depth[node] - depth[nbr]) + 1;
                if (cyclen % 2 == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}