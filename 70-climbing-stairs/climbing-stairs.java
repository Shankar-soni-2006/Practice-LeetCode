class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        return getSum(n, arr);
    }
    public int getSum(int n, int[] arr) {
        if (n <= 2) return n;
        if (arr[n] != 0) return arr[n];
        arr[n] = getSum(n - 1, arr) + getSum(n - 2, arr);
        return arr[n];
    }      
}
