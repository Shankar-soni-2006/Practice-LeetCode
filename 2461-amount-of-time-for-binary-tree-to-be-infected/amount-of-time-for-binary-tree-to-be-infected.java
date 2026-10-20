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
    Queue<TreeNode> q;
    Set<Integer> set;
    Map<Integer, TreeNode> p;
    TreeNode st;
    void dfs(TreeNode root, TreeNode par, int start) {
        if (root == null) return;
        if (par != null) {
            p.put(root.val, par);
        }
        if (root.val == start) {
            st = root;
        }
        dfs(root.left, root, start);
        dfs(root.right, root, start);
    }

    public int amountOfTime(TreeNode root, int start) {
        q = new ArrayDeque<>();
        set = new HashSet<>();
        p = new HashMap<>();
        st = null;
        dfs(root, null, start);
        q.add(st);
        set.add(start);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                // Left child
                if (cur.left != null &&
                    set.add(cur.left.val)) {
                    q.add(cur.left);
                    flag = true;
                }
                // Right child
                if (cur.right != null &&
                    set.add(cur.right.val)) {
                    q.add(cur.right);
                    flag = true;
                }
                // p
                TreeNode par = p.get(cur.val);
                if (par != null && set.add(par.val)) {
                    q.add(par);
                    flag = true;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}