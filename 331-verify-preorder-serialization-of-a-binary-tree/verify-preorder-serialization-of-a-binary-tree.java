class Solution {
    public boolean isValidSerialization(String preorder) {
        List<String> ls = new ArrayList<>(Arrays.asList(preorder.split(",")));
        Stack<String> st = new Stack<>();
        st.push("-1");
        for(int i = 0;i < ls.size(); i++){
            if(st.isEmpty()) return false;
            if(ls.get(i).equals("#")) st.pop();
            else st.push(ls.get(i));
        }
        return st.isEmpty();
    }
}