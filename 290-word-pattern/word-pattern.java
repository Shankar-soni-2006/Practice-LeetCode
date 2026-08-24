class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String,Character> map = new HashMap<>();
        String []arr = s.split(" ");
        if(pattern.length() !=arr.length) return false;
        int i = 0;
        for(String x:arr){
            char c = pattern.charAt(i++);
            if(map.containsKey(x)){
                if(map.get(x)!=c) return false;
            }
            else{
                if(map.containsValue(c)) return false;
                map.put(x,c);
            }
        }
        return true;
    }
}