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
    public int lheight(TreeNode x){
        if(x == null) return 0;
        int lh = 0;
        while(x != null){
            lh++;
            x = x.left;
        }
        return lh;
    }
    public int rheight(TreeNode x){
        if(x == null) return 0;
        int rh = 0;
        while(x != null){
            rh++;
            x = x.right;
        }
        return rh;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = lheight(root.left);
        int right = rheight(root.right);
        if(left == right) return (1 << (left+1)) - 1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}