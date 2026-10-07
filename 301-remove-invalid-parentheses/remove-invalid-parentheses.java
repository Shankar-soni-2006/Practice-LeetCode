import java.util.ArrayList;
import java.util.List;

class Solution {
    public void helper(String s, List<String> res, int i, int j, char[] p) {
        int cnt = 0;
        for (int k = i; k < s.length(); k++) {
            if (s.charAt(k) == p[0]) cnt++;
            if (s.charAt(k) == p[1]) cnt--;
            if (cnt < 0) {
                for (int l = j; l <= k; l++) {
                    if (s.charAt(l) == p[1] && (l == j || s.charAt(l - 1) != p[1])) {
                        helper(s.substring(0, l) + s.substring(l + 1), res, k, l, p);
                    }
                }
                return;
            }
        }
        String rev = new StringBuilder(s).reverse().toString();
        if (p[0] == '(') {
            helper(rev, res, 0, 0, new char[]{')', '('});
        } else {
            res.add(rev);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }
}
