class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, ans = 0;
        for(int i = 0; i<n; i++){
            sum+=nums[i];
            int temp = (sum%k+k)%k;
            if(map.containsKey(temp)) ans+=map.get(temp);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        return ans;
    }
}