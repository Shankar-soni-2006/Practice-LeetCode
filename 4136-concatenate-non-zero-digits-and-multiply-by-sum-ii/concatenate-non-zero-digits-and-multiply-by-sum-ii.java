class Solution {
    private static final int MOD = 1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] prefDigitSum = new int[n + 1];
        int[] prefCountNonZero = new int[n + 1];
        long[] prefValue = new long[n + 1];
        long[] power10 = new long[n + 1];
        power10[0] = 1;
        for (int i = 1; i <= n; i++) {
            power10[i] = (power10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            
            prefDigitSum[i + 1] = prefDigitSum[i] + digit;
            
            if (digit != 0) {
                prefCountNonZero[i + 1] = prefCountNonZero[i] + 1;
                prefValue[i + 1] = (prefValue[i] * 10 + digit) % MOD;
            } else {
                prefCountNonZero[i + 1] = prefCountNonZero[i];
                prefValue[i + 1] = prefValue[i]; 
            }
        }

        int q = queries.length;
        int[] arr = new int[q];

        for (int i = 0; i < q; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            long sum = prefDigitSum[R + 1] - prefDigitSum[L];
            int totalNonZerosAfterR = prefCountNonZero[n] - prefCountNonZero[R + 1];
            int totalNonZerosAfterL = prefCountNonZero[n] - prefCountNonZero[L];
            int nonZerosInRange = totalNonZerosAfterL - totalNonZerosAfterR;

            long x = prefValue[R + 1] - (prefValue[L] * power10[nonZerosInRange]) % MOD;
            if (x < 0) {
                x += MOD;
            }
            arr[i] = (int) ((x * sum) % MOD);
        }

        return arr;
    }
}