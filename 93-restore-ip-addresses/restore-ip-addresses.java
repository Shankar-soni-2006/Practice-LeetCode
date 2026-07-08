public class Solution {
     public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return ans;
        helper(0, 0, s, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int idx, int part, String s, List<String> current, List<String> ans) {
         if (part == 4) {
            if (idx == s.length()) {
                ans.add(String.join(".", current));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
           
            if (idx + i > s.length()) break; 
            String temp = s.substring(idx, idx + i);
            int val = Integer.parseInt(temp);
            if (temp.length() > 1 && temp.startsWith("0")) continue;
            if (val > 255) continue;
            current.add(temp);
            helper(idx + i, part + 1, s, current, ans);
            current.remove(current.size() - 1); 
        }
    }
}
