class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<matches.length;i++){
            map.putIfAbsent(matches[i][0],0);
            map.put(matches[i][1],map.getOrDefault(matches[i][1],0)+1);
        }
        List<Integer> l0 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        map.forEach((k,v)->{
            if(v==0) l0.add(k);
            else if(v==1) l1.add(k);
        });
        Collections.sort(l1);
        Collections.sort(l0);
        ans.add(l0);
        ans.add(l1);
        return ans;
    }
}