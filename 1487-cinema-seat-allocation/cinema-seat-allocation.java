import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] rS) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] x : rS){
            int r = x[0], c = x[1];
            if(!map.containsKey(r)) map.put(r, new ArrayList<>());
            map.get(r).add(c);
        }
        
        int ans = n * 2; 
        
        for(List<Integer> temp : map.values()){
            boolean l = true, m = true, ri = true;
            
            for(int i=2 ; i<=5; i++) { if(temp.contains(i)) { l = false; break; } }
            for(int i=4 ; i<=7; i++) { if(temp.contains(i)) { m = false; break; } }
            for(int i=6 ; i<=9; i++) { if(temp.contains(i)) { ri = false; break; } }
            
            if (l && ri) {
                continue; 
            } else if (l || m || ri) {
                ans -= 1; 
            } else {
                ans -= 2; 
            }
        }
        return ans;
    }
}
