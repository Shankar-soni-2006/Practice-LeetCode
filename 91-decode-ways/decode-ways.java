class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= s.length(); i++) {
            int cnt = 0;
            if (s.charAt(i - 1) != '0') {
                cnt += map.getOrDefault(i - 1, 0);
            }
            if (i >= 2) {
                int n = Integer.parseInt(s.substring(i - 2, i));
                if (n >= 10 && n <= 26) {
                    cnt += map.getOrDefault(i - 2, 0);
                }
            }
            map.put(i, cnt);
        }
        return map.get(s.length());
    }
}