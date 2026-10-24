
class Solution {
    int[] par = new int[26];
    public int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (px > py) {
            int temp = px;
            px = py;
            py = temp;
        }
        par[py] = px;
    }

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            par[i] = i;
        }
        int n = equations.length;
        for (int i = 0; i < n; i++) {
            String temp = equations[i];
            if (temp.charAt(1) == '=') {
                union(temp.charAt(0) - 'a', temp.charAt(3) - 'a');
            }
        }

        for (int i = 0; i < n; i++) {
            String temp = equations[i];

            if (temp.charAt(1) == '!') {
                int x = find(temp.charAt(0) - 'a');
                int y = find(temp.charAt(3) - 'a');
                if (x == y) return false;
            }
        }

        return true;
    }
}
