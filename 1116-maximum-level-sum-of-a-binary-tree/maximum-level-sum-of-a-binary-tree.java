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
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int ans = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int s = q.size();
            int val = 0;
            while(s-- > 0){
                root = q.poll();
                if(root.left!= null) q.add(root.left);
                if(root.right!= null) q.add(root.right);
                val+=root.val;
            }
            if(max < val){
                max = val;
                ans = level;
            }  
        }
        return ans;
    }
}