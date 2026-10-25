class Solution {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Integer> dist = new HashMap<>();
    Set<String> set = new HashSet<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans.clear();
        map.clear();
        dist.clear();
        set.clear();
        set.addAll(wordList);

        if (!set.contains(endWord)) return ans;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        dist.put(beginWord, 0);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();

            while (size-- > 0) {
                String s = q.poll();
                int d = dist.get(s);
                char[] a = s.toCharArray();
                for (int i = 0; i < a.length; i++) {
                    char old = a[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;

                        a[i] = c;
                        String t = new String(a);

                        if (!set.contains(t)) continue;

                        if (!dist.containsKey(t)) {
                            dist.put(t, d + 1);
                            q.add(t);
                            map.putIfAbsent(t, new ArrayList<>());
                            map.get(t).add(s);
                        } else if (dist.get(t) == d + 1) {
                            map.get(t).add(s);
                        }

                        if (t.equals(endWord)) {
                            found = true;
                        }
                    }

                    a[i] = old;
                }
            }
        }

        if (!dist.containsKey(endWord)) return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, path);

        return ans;
    }

    void dfs(String s, String begin, List<String> path) {
        if (s.equals(begin)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        for (String t : map.getOrDefault(s, new ArrayList<>())) {
            path.add(t);
            dfs(t, begin, path);
            path.remove(path.size() - 1);
        }
    }
}