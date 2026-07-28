class Solution {
    public String smallestPalindrome(String s) {
        int[] a = new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        int i=0,j=s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        int odd = -1;
        for(int k = 0;k<26;k++){
            if(a[k]%2!=0){
                odd= k;
                a[k]--;
            }
        }
        for(int k=0;k<26;k++){
            while(a[k]>0&& i<j){
                if(a[k]!=0){
                    sb.setCharAt(i, (char)(k + 'a'));
                    a[k]--;
                    i++;
                }
                if(a[k]!=0){
                    sb.setCharAt(j,(char)(k+'a'));
                    a[k]--;
                    j--;
                }
            }
        }
        if(odd!=0 && i==j){
            sb.setCharAt(i,(char)(odd+'a'));
        }

        return sb.toString();

    }
}