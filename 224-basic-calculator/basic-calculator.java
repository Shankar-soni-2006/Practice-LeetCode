class Solution {
    public int solve(int a, int b, char op){
        return op == '+' ? a+b : a-b;
    }
    public int calculate(String s) {
        int ans = 0;
        Stack<Character> st = new Stack<>();
        Stack<Integer> val = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ') continue;
            if(Character.isDigit(ch)){
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val.push(num);
            }else if(ch == '('){
                st.push(ch);
            }else if(ch == '+' || ch == '-'){
                if (ch == '-') {
                    int j = i - 1;
                    while (j >= 0 && s.charAt(j) == ' ') j--;
                    if (j < 0 || s.charAt(j) == '(') val.push(0);   
                }
                while(!st.isEmpty() && st.peek() != '('){
                    int b = val.pop();
                    int a = val.pop();
                    val.push(solve(a,b,st.pop()));
                }
                st.push(ch);
            }else if(ch == ')'){
                while (!st.isEmpty() && st.peek() != '(') { 
                    int b = val.pop();
                    int a = val.pop();
                    val.push(solve(a, b, st.pop())); 
                } 
                if (!st.isEmpty() && st.peek() == '(') st.pop();     
            }
        }
        while(!st.isEmpty()){
                int b = val.pop();
                int a = val.pop();
                val.push(solve(a,b,st.pop())); 
        }
        return val.isEmpty() ? 0 :val.pop();
    }
}