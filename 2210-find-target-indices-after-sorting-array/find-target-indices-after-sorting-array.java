class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int small=0,equal=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<target) small++;
            if(nums[i]==target) equal++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < equal; i++) {
            ans.add(small + i);
        }
        return ans;
    }
}