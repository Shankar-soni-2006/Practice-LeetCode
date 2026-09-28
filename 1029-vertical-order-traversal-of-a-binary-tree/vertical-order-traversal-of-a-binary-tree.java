/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public static class Pair {
        TreeNode node;
        int idx;
        int r;
        Pair(TreeNode node, int idx, int r) {
            this.node = node;
            this.idx = idx;
            this.r = r;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, List<Pair>> map = new HashMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0, 0));
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            TreeNode curr = temp.node;
            int index = temp.idx;
            int row = temp.r;
            min = Math.min(min, index);
            max = Math.max(max, index);
            if (curr.left != null) q.add(new Pair(curr.left, index - 1, row + 1));
            if (curr.right != null) q.add(new Pair(curr.right, index + 1, row + 1));
            if (!map.containsKey(index)) map.put(index, new ArrayList<>());
            map.get(index).add(temp);
        }
        map.forEach((key, val) -> {
            Collections.sort(val, (a, b) -> {
                if (a.r != b.r) {
                    return Integer.compare(a.r, b.r);
                }
                return Integer.compare(a.node.val, b.node.val);
            });
        });

        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                List<Integer> col = new ArrayList<>();
                for (Pair p : map.get(i)) {
                    col.add(p.node.val);
                }
                ans.add(col);
            }
        }

        return ans;
    }
}
