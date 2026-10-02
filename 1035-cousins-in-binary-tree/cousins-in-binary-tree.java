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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            boolean flagx = false, flagy = false;
            for(int i = 0 ;i < n; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) || 
                    (curr.left.val == y && curr.right.val == x)) return false;
                }
                if(curr.left != null){ 
                    q.add(curr.left);
                    if(curr.left.val == x) flagx = true;
                    if(curr.left.val == y) flagy = true;
                }
                if(curr.right != null){
                    q.add(curr.right);
                    if(curr.right.val == x) flagx = true;
                    if(curr.right.val == y) flagy = true;
                } 
            }
            if(flagx && flagy) return true;
            if (flagx || flagy) return false;
        }
        return false;
    }
}