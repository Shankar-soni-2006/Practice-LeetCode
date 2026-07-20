class Solution {
    Boolean[][] dp;
    public boolean isValid(int st, int open, String s){
        if(open == -1) return false;
        if(st == s.length()) return open == 0;
        if(dp[st][open] != null) return dp[st][open];
        boolean res;
        if(s.charAt(st) == '(') res=  isValid(st+1,open+1,s);
        else if(s.charAt(st) == ')') res = isValid(st+1,open-1,s);
        else{
            res = isValid(st+1,open,s) || isValid(st+1,open-1,s) || isValid(st+1,open+1,s);
        }
        dp[st][open] = res;
        return dp[st][open];
    }
    public boolean checkValidString(String s) {
        dp = new Boolean[101][101];
        return isValid(0,0,s);
    } 
}