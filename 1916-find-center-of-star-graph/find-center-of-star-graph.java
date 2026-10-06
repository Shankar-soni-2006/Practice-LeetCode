class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            mp.put(edges[i][0], mp.getOrDefault(edges[i][0],0)+1);
            mp.put(edges[i][1], mp.getOrDefault(edges[i][1],0)+1);
        }
        return mp.entrySet().stream().max(Map.Entry.comparingByValue())
               .map(Map.Entry :: getKey).orElse(null);
    }
}