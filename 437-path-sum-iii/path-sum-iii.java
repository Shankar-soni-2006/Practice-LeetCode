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
    public int helper(TreeNode root, long x){
        if(root == null) return 0;
        int cnt = 0;
        if (root.val == x) cnt++;
        cnt+=helper(root.left, x-root.val);
        cnt+=helper(root.right, x-root.val);
        return cnt;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int m = helper(root,targetSum);
        int l = pathSum(root.left, targetSum);
        int r = pathSum(root.right, targetSum);
        return l+r+m;
    }
}