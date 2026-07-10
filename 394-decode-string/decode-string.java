class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> sbt = new Stack<>();
        Stack<Integer> st = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            }else if(ch == '['){
                st.push(k);
                sbt.push(curr);
                curr = new StringBuilder();
                k = 0;
            }else if(ch == ']'){
                StringBuilder temp = sbt.pop();
                int ck = st.pop();
                for(int j = 0; j < ck; j++) temp.append(curr);
                curr = temp;
            }else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}