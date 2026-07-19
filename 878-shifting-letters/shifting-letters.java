class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int[] suffix = new int[n];
        suffix[n - 1] = shifts[n-1];
        for(int i = n-2; i >= 0; i--){
            suffix[i] = (suffix[i+1]+shifts[i]) % 26;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
           char ch = (char) ('a' + (s.charAt(i) - 'a' + suffix[i]) % 26);
           sb.append(ch);
        }
        return sb.toString();
    }
}