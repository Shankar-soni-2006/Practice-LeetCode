class Solution {
    public boolean isChecker(int[] nums, int k, int mid){
        int cntk = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] <= mid){
                cntk++;
                i++;
            }
        }
        return cntk >= k;
    }
    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE,h = Integer.MIN_VALUE;
        for(int x : nums){
            l = Math.min(l, x);
            h = Math.max(h, x);
        }
        while(l <= h){
            int mid = l+(h-l)/2;
            if(isChecker(nums, k, mid)) h = mid-1;
            else l = mid+1;
        }
        return l;
    }
}