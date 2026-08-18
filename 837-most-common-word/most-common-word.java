class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> temp = new HashMap<>();
        for (String s : banned) {
            s = s.toLowerCase();
            temp.put(s, temp.getOrDefault(s, 0) + 1);
        }
        String let = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        String[] words = let.split("\\s+");
        for (String s : words) {
            s = s.toLowerCase();
            if (!temp.containsKey(s))
                map.put(s, map.getOrDefault(s, 0) + 1);
        }
        String ans = "";
        int m = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (m < entry.getValue()) {
                ans = entry.getKey();
                m = entry.getValue();
            }
        }
        return ans;
    }
}