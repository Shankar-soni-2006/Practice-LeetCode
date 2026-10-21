class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        int n = exp.length();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            char c = exp.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> l  = diffWaysToCompute(exp.substring(0, i));
                List<Integer> r  = diffWaysToCompute(exp.substring(i+1, n));
                for(int x : l){
                    for(int y : r){
                        if(c == '+') ans.add(x+y);
                        if(c == '-') ans.add(x-y);
                        if(c == '*') ans.add(x*y);
                    }
                }
            }
        }
        if(ans.isEmpty()) ans.add(Integer.parseInt(exp));
        return ans;
    }
}