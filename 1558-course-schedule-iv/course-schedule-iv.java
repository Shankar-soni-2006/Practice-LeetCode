class Solution {
    public void topoSort(int n, int[][] edges,ArrayList<Integer> ans, boolean[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] in = new int[n];
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            in[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            ans.add(u);
            for (int v : adj.get(u)) {
                pre[u][v] = true;
                for (int i = 0; i < n; i++) {
                    if (pre[i][u]) {
                        pre[i][v] = true;
                    }
                }
                in[v]--;
                if (in[v] == 0) {
                    q.offer(v);
                }
            }
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[][] pre = new boolean[numCourses][numCourses];
        topoSort(numCourses, prerequisites, ans, pre);
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            int u = q[0];
            int v = q[1];
            res.add(pre[u][v]);
        }
        return res;
    }
}
