class Solution {
    public boolean dfs(int st, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[st] = 1;
        for (int x : adj.get(st)) {
            if (vis[x] == 1) {
                return false;
            }
            if (vis[x] == 0) {
                if (!dfs(x, adj, vis)) {
                    return false;
                }
            }
        }
        vis[st] = 2;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        int[] vis = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (!dfs(i, adj, vis)) {
                    return false;
                }
            }
        }
        return true;
    }
}
