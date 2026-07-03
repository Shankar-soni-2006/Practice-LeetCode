class Solution {
    public boolean makePairs(int[] nums, int p, int maxDiff){
        int count = 0;
        for(int i = 1; i < nums.length; ){
            if(nums[i]-nums[i-1] <= maxDiff){
                count++;
                i+=2;
            }else i++;
            if(count >= p) return true;
        }
        return false;
    }
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxDiff = 0;
        int l = 0, h = nums[n-1]-nums[0];
        while(l < h){
            int mid = l + (h - l) / 2;
            if(makePairs(nums,p,mid)) h = mid;
            else l = mid+1;
        }
        return l;
    }
}