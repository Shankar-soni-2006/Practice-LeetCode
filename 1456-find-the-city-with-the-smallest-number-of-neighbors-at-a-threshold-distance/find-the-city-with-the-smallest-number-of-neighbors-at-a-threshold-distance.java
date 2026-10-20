class Solution {
    public int[][] floydWarshall(int n, int[][] edges) {
        int INF = 100000000;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            dist[u][v] = weight;
            dist[v][u] = weight;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist;
    }

    public int findTheCity(int n, int[][] edges, int th) {
        int ans = 0, min = Integer.MAX_VALUE;
        int[][] dist = floydWarshall(n, edges);
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= th) curr++;
            }
            if (curr <= min) {
                min = curr;
                ans = i;
            }
        }
        return ans;
    }
}