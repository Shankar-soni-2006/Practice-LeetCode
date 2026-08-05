class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for(char c : s.toCharArray()) freq[c]++;
        List<Character> temp = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(!temp.contains(c)) temp.add(c);
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(temp,(a,b) -> freq[b] - freq[a]);
        for (char c : temp) {
            for (int i = 0; i < freq[c]; i++)  sb.append(c);    
        }
        return sb.toString();
    }
}