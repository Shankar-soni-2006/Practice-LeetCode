class Solution {
    public long minSumSquareDiff(int[] a, int[] b, int k1, int k2) {
        int n = a.length;
        long k = (long) k1 + k2, sum = 0;
        int[] d = new int[n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            d[i] = Math.abs(a[i] - b[i]);
            sum += d[i];
            mx = Math.max(mx, d[i]);
        }

        if (k >= sum) return 0;
        int l = 0, r = mx;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (check(d, m, k))r = m;
            else l = m + 1;
        }
        long used = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] > l) {
                used += d[i] - l;
                d[i] = l;
            }
        }
        long rem = k - used;
        for (int i = 0; i < n && rem > 0; i++) {
            if (d[i] == l && d[i] > 0) {
                d[i]--;
                rem--;
            }
        }
        for (int x : d) {
            ans += (long) x * x;
        }
        return ans;
    }
    public boolean check(int[] d, int m, long k) {
        long cnt = 0;
        for (int x : d) {
            if (x > m) cnt += x - m;
        }
        return cnt <= k;
    }
}
