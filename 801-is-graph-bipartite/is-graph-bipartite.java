class Solution {
    public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    boolean[] visited = new boolean[n];
    int[] depth = new int[n];
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            if (dfs(graph, i, -1, 0, visited, depth)) {
                return false;
            }
        }
    }
    return true;
}

public boolean dfs(int[][] graph,int node,
        int parent,
        int currentDepth,
        boolean[] visited,
        int[] depth) {

    visited[node] = true;
    depth[node] = currentDepth;

    for (int neighbor : graph[node]) {

        if (neighbor == parent) {
            continue;
        }

        if (!visited[neighbor]) {

            if (dfs(
                    graph,
                    neighbor,
                    node,
                    currentDepth + 1,
                    visited,
                    depth)) {
                return true;
            }
        } else {
            int cycleLength = Math.abs(depth[node] - depth[neighbor]) + 1;
            if (cycleLength % 2 == 1) {
                return true;
            }
        }
    }

    return false;
}
}