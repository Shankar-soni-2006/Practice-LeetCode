class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int maxScoreDiff = Integer.MIN_VALUE;
            int currentTake = 0;
            for (int k = 0; k < 3 && i + k < n; k++) {
                currentTake += stoneValue[i + k];
                int currentDiff = currentTake - dp[i + k + 1];
                maxScoreDiff = Math.max(maxScoreDiff, currentDiff);
            }
            dp[i] = maxScoreDiff;
        }
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
