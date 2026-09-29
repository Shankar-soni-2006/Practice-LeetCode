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
    public TreeNode helper(TreeNode root){
        TreeNode current = root.right;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right =  deleteNode(root.right, key);
        else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode temp = helper(root);
            root.val = temp.val;
            root.right = deleteNode(root.right, temp.val);
        }
        return root;
    }
}