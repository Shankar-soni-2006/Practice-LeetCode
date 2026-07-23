import java.util.Stack;

class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < op.length; i++) {
            if (op[i].equals("C") && !st.isEmpty()) {
                st.pop();
            } else if (op[i].equals("D") && !st.isEmpty()) {
                st.push(st.peek() * 2);
            } else if (op[i].equals("+")) {
                if (st.size() >= 2) {
                    int a = st.pop();
                    int b = st.peek();
                    st.push(a);
                    st.push(a + b);
                }
            } else {
                st.push(Integer.parseInt(op[i]));
            }
        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}
