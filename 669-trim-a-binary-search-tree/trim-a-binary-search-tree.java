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
    public TreeNode helper(TreeNode root, int l, int h){
        if(root == null) return null;
        if(root.val < l) return helper(root.right, l, h);
        if(root.val > h) return helper(root.left, l, h);
        root.left = helper(root.left, l, h);
        root.right = helper(root.right, l, h);
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return root;
        return helper(root, low, high);
    }
}