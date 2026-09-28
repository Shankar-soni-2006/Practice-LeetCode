class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int max = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '(') st.push(ch);
            else if(ch == ')') st.pop();
            max = Math.max(st.size(), max);
        }
        return max;
    }
}