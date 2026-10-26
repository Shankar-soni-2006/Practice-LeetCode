class Solution {
    class DisJointSet {
        int[] parent;
        int[] size;
        DisJointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int findUltParent(int u) {
            if (parent[u] == u) {
                return u;
            }
            return parent[u] = findUltParent(parent[u]);
        }
        void unionBySize(int u, int v) {
            int ultParU = findUltParent(u);
            int ultParV = findUltParent(v);
            if (ultParU == ultParV) {
                return;
            }
            if (size[ultParU] < size[ultParV]) {
                parent[ultParU] = ultParV;
                size[ultParV] += size[ultParU];
            } else {
                parent[ultParV] = ultParU;
                size[ultParU] += size[ultParV];
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int xi = points[i][0];
            int yi = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int xj = points[j][0];
                int yj = points[j][1];
                int distance = Math.abs(xi - xj) + Math.abs(yi - yj);
                edges.add(new int[]{i, j, distance});
            }
        }
        edges.sort((a, b) -> Integer.compare(a[2], b[2]));
        DisJointSet djs = new DisJointSet(n);
        int ans = 0;
        int count = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (djs.findUltParent(u) != djs.findUltParent(v)) {
                ans += wt;
                djs.unionBySize(u, v);
                count++;
                if (count == n - 1) {
                    break;
                }
            }
        }
        return ans;
    }
}