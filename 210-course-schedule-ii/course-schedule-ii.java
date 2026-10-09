class Solution {
    public void topoSort(int V, int[][] edges, ArrayList<Integer> ans) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int top = q.poll();
            ans.add(top);
            for (int next : adj.get(top)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> ans = new ArrayList<>();
        topoSort(numCourses, prerequisites, ans);
        int[] arr = new int[numCourses];
        if (ans.size() != numCourses) return new int[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(ans.size() - i - 1);
        }
        return arr;
    }
}