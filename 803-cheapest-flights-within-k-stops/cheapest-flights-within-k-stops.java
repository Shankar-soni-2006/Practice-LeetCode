class Solution {
    public int[] bellmanFord(int n, int[][] edges, int src, int k){
        int[] dist = new int[n];
        int MAX = (int)1e5;
        Arrays.fill(dist, MAX);
        dist[src] = 0;
        for(int i = 0; i <= k; i++){
            int[] temp = dist.clone();
            for(int[] x : edges){
                int u = x[0], v = x[1], w = x[2];
                if(dist[u] != MAX && dist[u]+w < temp[v]){
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }
        return dist;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] ans = bellmanFord(n, flights, src , k);
        return ans[dst] == (int)1e5 ? -1 : ans[dst];
    }
}