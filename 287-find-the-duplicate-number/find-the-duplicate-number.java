class Solution {
    public int findDuplicate(int[] nums) {
       HashSet<Integer> set =  new HashSet<>();
       int i = 0;
       while(i < nums.length){
         if(set.contains(nums[i])) return nums[i];
         set.add(nums[i]);
         i++;
       }
       return -1;
    }
}