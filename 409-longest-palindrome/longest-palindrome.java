class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(char c : s.toCharArray()) freq[c]++;
        int max = 0;
        boolean flag = false;
        for(int x : freq){
            max+=(x / 2) * 2;
            if(x % 2 != 0) flag = true;
        }
        if(flag) max+=1;
        return max;
    }
}