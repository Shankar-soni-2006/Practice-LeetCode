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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> lsum = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            lsum.add(sum);
        }
        q.add(root);
        root.val = 0;
        int lvl = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            int nextlSum = (lvl + 1 < lsum.size()) ? lsum.get(lvl + 1) : 0;
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                int req = 0;
                if (curr.left != null) {
                    req += curr.left.val;
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    req += curr.right.val;
                    q.add(curr.right);
                }
                if (curr.left != null) curr.left.val = nextlSum - req;
                if (curr.right != null) curr.right.val = nextlSum - req;
            }
            lvl++;
        }

        return root;
    }
}