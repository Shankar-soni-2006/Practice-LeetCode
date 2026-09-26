class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for(List<String> st : knowledge){
            map.put(st.get(0),st.get(1));
        }
        int  i = 0;
        while(i < n){
            char ch = s.charAt(i);
            int j = i+1;
            if(s.charAt(i) == '('){
                while(j < n && s.charAt(j) != ')') j++;
                String temp = s.substring(i+1, j);
                ans.append(map.getOrDefault(temp, "?"));
                i = j+1;
            }
            else{
                ans.append(ch);
                i++;
            }
        }
        return ans.toString();
    }
}