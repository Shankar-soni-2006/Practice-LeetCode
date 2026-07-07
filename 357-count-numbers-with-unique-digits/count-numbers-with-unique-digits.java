class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int ans = 10;
        int y = 9;
        int z = 9;
        for(int i = 2; i <= n; i++){
            y *= z;
            ans += y;
            z--;
        }
        return ans;
    }
}