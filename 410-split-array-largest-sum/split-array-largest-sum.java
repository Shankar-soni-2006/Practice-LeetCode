class Solution {
    public boolean isPossible(int[] nums,int k,int mid){
        int split = 0, curr = 0;
        for(int i = 0;i < nums.length; i++){
            if(curr < nums[i]){
                split++;
                curr = mid;
                curr-=nums[i];
            }else{
                curr-=nums[i];
            }
        }
        return split <= k;
    }
    public int splitArray(int[] nums, int k){
        if(nums.length<k) return -1;
        int left=0;
        
        int right=0;
        for(int i:nums){
            right+=i;
            left = Math.max(left, i);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPossible(nums,k,mid)) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
}																	