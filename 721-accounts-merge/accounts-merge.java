class Solution {
    int[] par;
    public int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;
        if (px > py) {
            int temp = px;
            px = py;
            py = temp;
        }
        par[py] = px;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> etou = new HashMap<>();
        int n = accounts.size();
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String temp = accounts.get(i).get(j);
                if (etou.containsKey(temp)) {
                    union(i, etou.get(temp));
                } else {
                    etou.put(temp, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> req = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = find(i);
            req.putIfAbsent(x, new TreeSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) {
                req.get(x).add(accounts.get(i).get(j));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (int x : req.keySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(x).get(0));
            temp.addAll(req.get(x));
            res.add(temp);
        }

        return res;
    }
}
