import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s = new HashSet<>(wordList);
        if (!s.contains(endWord)) return 0;
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int l = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String temp = q.poll();
                if (temp.equals(endWord)) return l;
                char[] arr = temp.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char org = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == org) continue;
                        arr[j] = c;
                        String next = new String(arr);
                        if (s.contains(next)) {
                            q.add(next);
                            s.remove(next);
                        }
                    }
                    arr[j] = org;
                }
            }
            l++;
        }
        return 0;
    }
}
