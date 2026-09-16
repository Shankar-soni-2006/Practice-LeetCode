class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        
        // If we don't have enough points to even form k segments
        if (n - 1 < k) {
            return 0;
        }
        
        int total = n + k - 1;
        int choose = 2 * k;
        
        // Compute C(total, choose) % MOD
        return (int) nCr(total, choose, MOD);
    }
    
    private long nCr(int n, int r, int mod) {
        if (r > n || r < 0) return 0;
        if (r == 0 || r == n) return 1;
        if (r > n - r) r = n - r;
        long num = 1;
        long den = 1;
        
        for (int i = 1; i <= r; i++) {
            num = (num * (n - i + 1)) % mod;
            den = (den * i) % mod;
        }
        return (num * modIn(den, mod)) % mod;
    }
    
    public long modIn(long n, int mod) {
        return pow(n, mod - 2, mod);
    }
    
    public long pow(long base, long exp, int mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
