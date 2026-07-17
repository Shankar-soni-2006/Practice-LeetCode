class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(') st.push(i);
            else{
                if(st.isEmpty()) continue;
                vis[i] = 1;
                vis[st.pop()] = 1;
            }
        }
        int count = 0, max = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 1) count++;
            else count = 0;
            max = Math.max(count,max);
        }
        return max;
    }
}