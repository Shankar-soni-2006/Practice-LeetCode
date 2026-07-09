class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;

        int[] diff = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (lights[i] > 0) {
                int l = Math.max(0, i - lights[i]);
                int r = Math.min(n - 1, i + lights[i]);
                diff[l]++;
                if (r + 1 < n) diff[r + 1]--;
            }
        }

        boolean[] cover = new boolean[n];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            cover[i] = cur > 0;
        }

        int ans = 0;
        int i = 0;

        while (i < n) {
            if (cover[i]) {
                i++;
                continue;
            }

            ans++;

            int pos = Math.min(i + 1, n - 1);

            for (int j = Math.max(0, pos - 1); j <= Math.min(n - 1, pos + 1); j++) {
                cover[j] = true;
            }

            while (i < n && cover[i]) i++;
        }

        return ans;
    }
}