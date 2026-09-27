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
    public int[] helper(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        int[] curr = new int[2];
        curr[0] = root.val + l[1] +  r[1];
        curr[1] = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);
        return curr;
    }
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }
}