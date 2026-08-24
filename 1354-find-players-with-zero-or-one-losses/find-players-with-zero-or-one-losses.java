class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] x : matches){
            int w = x[0], l = x[1];
            set.add(w);
            set.add(l);
            map.put(l, map.getOrDefault(l,0)+1);
        }
        List<Integer> temp0 = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(set);
        Collections.sort(temp);    
        for (int x : temp) {
            if (!map.containsKey(x)) temp0.add(x);    
            if (map.containsKey(x) && map.get(x) == 1) temp1.add(x);    
        }
        Collections.sort(temp0);
        Collections.sort(temp1);
        res.add(temp0);
        res.add(temp1);
        return res;
    }
}