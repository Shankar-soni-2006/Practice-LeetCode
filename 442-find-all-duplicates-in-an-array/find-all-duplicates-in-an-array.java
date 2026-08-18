class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0)+1);
        map.forEach((k, v)->{
            if(v > 1) ls.add(k);
        });
        return ls;
    }
}