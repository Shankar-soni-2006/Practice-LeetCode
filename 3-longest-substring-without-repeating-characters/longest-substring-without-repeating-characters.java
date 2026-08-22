class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;    
        for (int r = 0; r < n; r++) {
            char temp = s.charAt(r);
            if (map.containsKey(temp)) {
                l = Math.max(l, map.get(temp) + 1);
            }
            map.put(temp, r);
            ans = Math.max(ans, r- l+ 1);
        }    
        return ans;
    }
}