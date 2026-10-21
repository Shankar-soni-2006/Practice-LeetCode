
import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) ls.add(new ArrayList<>());
        for (int[] x : flights) {
            ls.get(x[0]).add(new int[]{x[1], x[2]});
        }
        Queue<int[]> q = new ArrayDeque<>();
        int[] d = new int[n];
        Arrays.fill(d, (int) 1e5);
        q.add(new int[]{0, src, 0});
        d[src] = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], v = curr[1], w = curr[2];
            if (u > k) continue;
            for (int[] x : ls.get(v)) {
                int nx = x[0];
                int nd = x[1];
                int ud = w + nd;
                if (ud < d[nx] && u <= k) {
                    d[nx] = ud;
                    q.add(new int[]{u + 1, nx, ud});
                }
            }
        }
        return d[dst] == (int) 1e5 ? -1 : d[dst];
    }
}
