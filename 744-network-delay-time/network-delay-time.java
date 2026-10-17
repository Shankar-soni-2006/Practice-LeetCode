class Solution {
    public int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new int[] {0, src});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currentDist = curr[0];
            int u = curr[1];
            if (currentDist > dist[u]) continue;
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[] {dist[v], v});
                }
            }
        }
        return dist;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
         ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        int[] dist = dijkstra(n, adj, k);
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}