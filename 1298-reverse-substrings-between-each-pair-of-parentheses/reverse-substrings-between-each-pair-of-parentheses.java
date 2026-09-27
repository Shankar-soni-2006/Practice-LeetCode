import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                StringBuilder temp = new StringBuilder();
                while (st.peek() != '(') {
                    temp.append(st.pop());
                }
                st.pop(); 
                for (char c : temp.toString().toCharArray()) {
                    st.push(c);
                }
            } else {
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}