class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i,map.getOrDefault(i,0)+1);
        Arrays.sort(nums);
        for(int num : nums){
            if(map.get(num) > 0){
                for(int i = 0; i < k; i++){
                    int curr = num+i;
                    int count = map.getOrDefault(curr,0);
                    if(count <= 0) return false;
                    map.put(curr,count-1);
                }
            }
        }
        return true;
    }
}