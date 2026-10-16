class Solution {
    List<Integer> dijkstra(int src, int n, List<List<int[]>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min heap
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new int[] { 0, src });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];
            if (d > dist[u])
                continue;
            for (int[] p : adj.get(u)) {
                int v = p[0];
                int w = p[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[] { dist[v], v });
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int d : dist)
            res.add(d);
        return res;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int v = n;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adj.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        int min = Integer.MAX_VALUE;
        int city = 0;
        for (int i = 0; i < v; i++) {
            List<Integer> arr = dijkstra(i, v, adj);
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && arr.get(j) <= distanceThreshold)
                    cur++;
            }
            if (cur <= min) {
                min = cur;
                city = i;
            }
        }
        return city;
    }
}