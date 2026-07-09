class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(!a.isEmpty()) a.pop();
            }else a.push(s.charAt(i));
        }
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(!b.isEmpty()) b.pop();
            }else b.push(t.charAt(i));
        }
        
        if(a.size() != b.size()) return false;
        StringBuilder as = new StringBuilder();
        StringBuilder bt = new StringBuilder();
        for(int c : a) as.append(c);
        for(int c : b) bt.append(c);
        return as.toString().equals(bt.toString());
    }
}