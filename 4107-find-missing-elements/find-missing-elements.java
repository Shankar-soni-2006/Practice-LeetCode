class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean []arr = new boolean[101];
        List<Integer> ans = new ArrayList<>();
        int min = 101,max = 0;
        for(int i:nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
            arr[i] = true;
        }
        for(int i=min;i<=max;i++){
            if(arr[i]==false) ans.add(i);
        }
        return ans;
    }
}