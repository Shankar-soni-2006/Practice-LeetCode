class Solution {
    public void helper(int n, int x, int y, List<String> ans, String s){
        if(x == n && y == n){
            ans.add(s);
            return;
        }
        if(x < n) helper(n, x+1, y, ans, s +'(');
        if(y < x) helper(n, x, y+1, ans, s +')');
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, ans, "");
        return ans;
    }
}