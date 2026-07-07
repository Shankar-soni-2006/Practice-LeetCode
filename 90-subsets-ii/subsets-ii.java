class Solution {
    public void getSubset(int idx, List<Integer> temp, List<List<Integer>> ans, int[] nums ){
        if(idx == nums.length){
            if(ans.contains(temp)) return;
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        getSubset(idx+1,temp, ans, nums);
        temp.remove(temp.size()-1);
        getSubset(idx+1,temp,ans, nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        getSubset(0,temp,ans,nums);
        System.gc();
        return ans;
    }
}