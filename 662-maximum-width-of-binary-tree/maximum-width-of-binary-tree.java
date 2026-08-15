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
    public static class Pair{
        TreeNode node;
        long idx;
        Pair(TreeNode node, long idx){
            this.node  = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root,0l));
        long max = 0;
        while(!q.isEmpty()){
            int n = q.size();
            long min = q.peek().idx;
            long st = 0, end = 0;
            for(int i = 0; i < n; i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                long index = curr.idx - min;
                if(i == 0) st = index;
                if(i == n-1) end = index;
                if(node.left != null){
                    q.add(new Pair(node.left,(2*index)));
                } 
                if(node.right != null){
                    q.add(new Pair(node.right,(2*index+1)));
                }
            } 
            max = Math.max(max,end-st+1);
        }
        return (int)max;
    }
}