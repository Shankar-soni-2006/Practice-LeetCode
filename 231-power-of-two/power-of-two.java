class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while(n % 2 == 0){
            return isPowerOfTwo(n/2);
        }
        return n==1;
    }
}