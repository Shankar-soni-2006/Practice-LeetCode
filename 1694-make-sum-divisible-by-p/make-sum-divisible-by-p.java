
class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums)  totalSum += num;    
        int target = (int) (totalSum % p);
        if (target == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        totalSum = 0;
        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            int mod = (int) (totalSum % p);
            int reqMod = (mod- target+ p) % p;
            if (map.containsKey(reqMod)) {
                min = Math.min(min, i - map.get(reqMod));
            }
            map.put(mod, i);
        }
        return min == nums.length ? -1 : min; 
    }
}