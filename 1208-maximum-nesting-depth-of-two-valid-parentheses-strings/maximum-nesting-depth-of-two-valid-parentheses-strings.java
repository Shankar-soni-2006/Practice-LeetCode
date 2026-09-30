class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int x = 0;
        for(int i = 0 ;i < seq.length(); i++){
            char ch = seq.charAt(i);
            if(ch == '('){
                x++;
                ans[i] = x % 2;
            }else{
                ans[i] = x % 2;
                x--;
            }
        }
        return ans;
    }
}