
import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] gr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) gr[i] = new ArrayList<>();
        for (int[] x : dislikes) {
            gr[x[0]].add(x[1]);
            gr[x[1]].add(x[0]);
        }
        boolean[] vis = new boolean[n + 1];
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (dfs(gr, i, -1, 0, vis, d)) return false;
            }
        }
        return true;
    }

    public boolean dfs(List<Integer>[] gr, int node, int parent,int curr, boolean[] vis, int[] d) {
        vis[node] = true;
        d[node] = curr;
        for (int nbr : gr[node]) {
            if (nbr == parent) continue;
            if (!vis[nbr]) {
                if (dfs(gr, nbr, node, curr + 1, vis, d)) {
                    return true;
                }
            } else {
                if (Math.abs(d[node] - d[nbr]) % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
