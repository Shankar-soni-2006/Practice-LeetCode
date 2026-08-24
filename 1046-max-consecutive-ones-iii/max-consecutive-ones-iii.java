class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0, cnt = 0, l = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] == 0) cnt++;
            while(cnt > k){
                if(nums[l] == 0) cnt--;
                l++;
            }
            max = Math.max(max, i-l+1);
        }
        return max;
    }
}