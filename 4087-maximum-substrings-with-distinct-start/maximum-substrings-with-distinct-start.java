class Solution {
    public int maxDistinct(String s) {
        int count = 1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // for(int i = 1; i < s.length(); i++){
        //     if(s.charAt(i)!=(s.charAt(i-1))) count++;
        // }
        return map.size();
    }
}