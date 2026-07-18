class Solution {
    public boolean check(int[] nums, int mid, int k){
        int sum = 0;
        for(int i : nums){
            sum+=(i+mid-1)/mid;
        }
        return sum <= k;
    }
    public int smallestDivisor(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 1, h = nums[nums.length-1];
        while(l <= h){
            int mid = l+(h-l)/2;
            if(check(nums, mid, k)) h = mid - 1;
            else l = mid+1;
        }
        return l;
    }
}