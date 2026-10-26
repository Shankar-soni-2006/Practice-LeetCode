
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
            return 1.0 / myPow(x, -(n + 1)) / x;
        }
        double res = myPow(x, n / 2);
        if (n % 2 == 0) return res * res;
        return x * res * res;
    }
}
