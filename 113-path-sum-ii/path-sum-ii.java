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
    public void helper(TreeNode root, int targetSum, List<List<Integer>> res, int x,List<Integer> temp){
        if(root == null) return;
        x+=root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == x){
                res.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size()-1);
            return;
        }
        helper(root.left, targetSum, res, x, temp);
        helper(root.right, targetSum, res, x, temp);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(root, targetSum, res, 0, temp);
        return res;
    }
}