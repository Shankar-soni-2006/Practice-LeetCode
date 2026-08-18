class Solution {
    public boolean isChecker(int[] nums, int maxOp, int mid){
        long op = 0;
        for(int x : nums){
            if(x > mid){
                op+=(x-1)/mid;
            } 
        }
        return op <= maxOp;
    }
    public int minimumSize(int[] nums, int maxOp) {
        int l = 1, h = 0;
        for(int x : nums) h = Math.max(h,x);
        while(l<=h){
            int mid = l+(h-l)/2;
            if(isChecker(nums, maxOp, mid)) h = mid-1;
            else l = mid+1;
        }
        return l;
    }
}