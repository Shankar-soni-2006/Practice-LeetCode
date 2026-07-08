class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n/2;
        String v = "aeiouAEIOU";
        int vowelcount = 0;
        for(int i = 0; i < mid; i++){
            if(v.indexOf(s.charAt(i)) != -1) vowelcount++;
            if(v.indexOf(s.charAt(i+mid)) != -1) vowelcount--;
        }
        return vowelcount == 0;
    }
}