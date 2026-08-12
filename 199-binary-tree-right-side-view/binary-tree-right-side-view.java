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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int i = 0;
            while(s-- >0){
                root = q.poll();
                if(root.left!=null) q.add(root.left);
                if(root.right!=null) q.add(root.right);
                i = root.val;
            }
            res.add(i);
        }
        return res;
    }
}