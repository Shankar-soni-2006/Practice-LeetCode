class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        HashMap<Character, Integer> freqt = new HashMap<>();
        for(int i = 0;i < m; i++){
            freqt.put(t.charAt(i),freqt.getOrDefault(t.charAt(i),0)+1);
        }
        HashMap<Character, Integer> freqs = new HashMap<>();
        int j = 0, min = Integer.MAX_VALUE, cnt = 0, req = freqt.size(),st = -1;
        for(int i = 0;i < n; i++){
            char c = s.charAt(i);
            freqs.put(c,freqs.getOrDefault(c,0)+1);
            if(freqt.containsKey(c) && freqt.get(c).intValue() == freqs.get(c).intValue()){
                cnt++;
            }
            while(cnt == req){
                if(i-j+1 < min){
                    min = i-j+1;
                    st = j;
                }
                char lchar = s.charAt(j);
                freqs.put(lchar, freqs.get(lchar)-1);
                if(freqt.containsKey(lchar) && freqs.get(lchar) < freqt.get(lchar)) cnt--;     
                j++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(st,st+min);
    }
}


