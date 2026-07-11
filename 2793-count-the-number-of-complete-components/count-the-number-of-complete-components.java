class Graph {
    int n;
    ArrayList<Integer>[] adj;
    Graph(int n) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    void addEdges(int src, int des) {
        adj[src].add(des);
        adj[des].add(src);
    }
    void dfs(int src, boolean[] vis, int[] info) {
        if (vis[src]) return;
        vis[src] = true;
        info[0]++;
        info[1] += adj[src].size(); 
        for (int i : adj[src]) {
            dfs(i, vis, info);
        }
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Graph g = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            g.addEdges(edges[i][0], edges[i][1]);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            int[] info = new int[2];
            g.dfs(i, vis, info);
            int v = info[0];
            int ec = info[1] / 2;
            if (ec == (v * (v - 1)) / 2) {
                count++;
            }
        }
        return count;
    }
}