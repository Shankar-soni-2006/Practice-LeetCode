class Solution {
    public int ub(int[] arr, int target){
        int l = 0, h = arr.length;
        while(l < h){
            int mid = l+(h-l)/2;
            if(arr[mid]<=target){
                l = mid+1;
            }else h = mid;
        }
        return l;
    }

    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = 0;
        int n = nums.length;
        int[] pre = new int[n + 1];
        pre[0] = 0;
        
        for(int i = 0; i < n; i++){
            pre[i + 1] = pre[i] + (nums[i] == 0 ? 1 : 0);
        }
        
        for(int i = 1; i <= n; i++){
            int target = pre[i] - k - 1;
            int temp = ub(pre, target);
            max = Math.max(max, i - temp);
        }
        return max;
    }
}
