class Solution {
    public boolean checkInclusion(String p, String s) {
        int n2 = p.length();
        int n1 = s.length();
        int []fr = new int[26];
        for(int i=0;i<n2;i++) fr[p.charAt(i)-'a']++; 
        for(int i=0;i<n1;i++){
            int j=i;
            int []fr1 = new int[26];
            while(j<n1 && j<i+n2){
                fr1[s.charAt(j)-'a']++;
                j++;
            }
            boolean flag = true;
            for(int k=0;k<26;k++){
                if(fr1[k]!=fr[k]){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}