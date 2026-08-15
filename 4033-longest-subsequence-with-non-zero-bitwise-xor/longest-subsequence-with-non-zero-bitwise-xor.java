class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        int xor = 0;
        for(int i : nums){
            xor^=i;
            if(i != 0) flag = true;
        }
        if(xor != 0) return n;
        return flag ? n-1 : 0;
    }
}