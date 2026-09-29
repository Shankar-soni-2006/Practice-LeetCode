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
    public void helper(TreeNode root, int val , int depth, int curr){
        if(root == null) return;
        if(curr == depth-1){
            TreeNode nl = new TreeNode(val);
            TreeNode nr = new TreeNode(val);
            nl.left = root.left;
            nr.right = root.right;
            root.left = nl;
            root.right = nr;
        }
        helper(root.left, val, depth, curr+1);
        helper(root.right, val, depth, curr+1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return null;
        if(depth == 1){
            TreeNode x = new TreeNode(val);
            x.left = root;
            return x;
        }
        helper(root, val, depth, 1);
        return root;
    }
}