class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i = 1;i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st.push(s.charAt(i));
            else{
                if(!st.isEmpty() && st.peek() == '(' && ch == ')') st.pop();
                else if(!st.isEmpty() && st.peek() == '[' && ch == ']') st.pop();
                else if(!st.isEmpty() && st.peek() == '{' && ch == '}') st.pop();
                else return false;
            }
        }
        if(st.size()!=0) return false;
        return true;
    }
}