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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Long> idx = new ArrayDeque<>();
        q.add(root);
        idx.add(0L);
        long max = 0;
        while(!q.isEmpty()){
            int n = q.size();
            long st = idx.peek(), end = st;
            for(int i = 0; i < n; i++){
                root = q.poll();
                long index = idx.poll();
                end = index;
                if(root.left != null){
                    q.add(root.left);
                    idx.add(2*index);
                } 
                if(root.right != null){
                    q.add(root.right);
                    idx.add(2*index+1);
                }
            } 
            max = Math.max(max,end-st+1);
        }
        return (int)max;
    }
}