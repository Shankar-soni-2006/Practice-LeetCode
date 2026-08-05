class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words,(a,b)->{
            if(a.length() != b.length()){
               return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });
        List<String> temp = new ArrayList<>();
        String res = "";
        for(String x : words){
            if(x.length() == 1 || temp.contains(x.substring(0,x.length()-1))){
                temp.add(x);
                if(x.length() > res.length()) res = x;
            } 
        }
        return res;
    }
}