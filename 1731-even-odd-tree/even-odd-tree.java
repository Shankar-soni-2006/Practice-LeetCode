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
    // public boolean checker(boolean flag, Deque<TreeNode> q){
    //     if(flag){
    //         int val = 0;
    //         for(var i : q){
    //             if(i.val % 2 == 1){
    //                 if(val >= i.val) return false;
    //                 val = i.val;
    //             }
    //         }
    //         if(val == 0) return false;
    //     }else{
    //         int val = 100001;
    //         for(var i : q){
    //             if(i.val % 2 == 0){
    //                 if(val <= i.val) return false;
    //                 val = i.val;
    //             }
    //         }
    //         if(val == 100001) return false;
    //     }
    //     return true;
    // }
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int lvl = 0;
        while(!q.isEmpty()){
            int n = q.size();
            int prev = lvl%2 == 0 ? 0 : Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                root = q.poll();
                if(lvl % 2 == 0){
                    if(root.val % 2 == 0 || root.val <= prev) return false;
                }else{
                    if(root.val % 2 == 1 || root.val >= prev) return false;
                }
                prev = root.val;
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            }
            lvl++;
        }
        return true;
    }
}