class Solution {
    int[][] dp;
    public int helper(int i, int j, int n, List<List<Integer>> h) {
        if (i == n - 1) {
            return h.get(i).get(j);
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int x = helper(i + 1, j, n, h);
        int y = helper(i + 1, j + 1, n, h);
        return dp[i][j] = Math.min(x, y) + h.get(i).get(j);
    }

    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        dp = new int[n][n];
        for (int[] x : dp) {
            Arrays.fill(x, Integer.MIN_VALUE);
        }
        return helper(0, 0, n, t);
    }
}
