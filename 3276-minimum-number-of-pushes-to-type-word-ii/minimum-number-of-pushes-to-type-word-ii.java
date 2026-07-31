class Solution {
    public int minimumPushes(String word) {
          int[] a = new int[26];
        for(int i=0;i<word.length();i++) {
            a[word.charAt(i)-'a']++;
        }
        Arrays.sort(a);
        int res = 0;
        for(int i=0;i<26;i++) {
            res +=a[26-i-1]*(i/8+1);
        }
        return res;
    }
}