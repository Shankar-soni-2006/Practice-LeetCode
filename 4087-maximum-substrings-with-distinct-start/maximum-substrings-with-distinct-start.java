class Solution {
    public int maxDistinct(String s) {
        int count = 0;
        boolean[] arr = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            if(!arr[s.charAt(i)-'a']){
                arr[s.charAt(i)-'a'] = true;
                count++;
            }
        }
        return count;
    }
}