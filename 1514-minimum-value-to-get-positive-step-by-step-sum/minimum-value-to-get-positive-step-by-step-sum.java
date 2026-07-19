class Solution {
    public int minStartValue(int[] nums) {
        int prefix = 0, min = Integer.MAX_VALUE;
        for(int x : nums){
            prefix+=x;
            min = Math.min(min, prefix);
        }
        return Math.max(1, 1-min);
    }
}