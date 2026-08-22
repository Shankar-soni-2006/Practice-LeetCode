class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n  = s.length();
        if(n == 0 || n == 1) return n;
        int l = 0, r = 0;
        int ans = 0;
        boolean[] vis = new boolean[256];
        while(r < n){
            while(vis[s.charAt(r)]){
                vis[s.charAt(l)] = false;
                l++;
            }
            vis[s.charAt(r)] = true;
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}