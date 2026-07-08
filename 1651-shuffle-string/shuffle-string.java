class Solution {
    public String restoreString(String s, int[] idx) {
        char[] res = new char[s.length()];
        for(int i = 0;i < s.length(); i++){
            res[idx[i]] = s.charAt(i);
        }
        return new String(res);
    }
}