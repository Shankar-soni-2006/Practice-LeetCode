
import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        int INF = (int) 1e8;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] edge : prerequisites) {
            dist[edge[0]][edge[1]] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF &&
                        dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            int u = q[0];
            int v = q[1];
            res.add(dist[u][v] != INF && u != v);
        }
        return res;
    }
}
