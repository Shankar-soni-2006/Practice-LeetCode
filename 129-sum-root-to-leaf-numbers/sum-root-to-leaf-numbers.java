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
    public void support(TreeNode root, List<String> ans, String sb){
        if(root == null) return;
       
        if(root.left == null && root.right == null){
           sb+=Integer.toString(root.val);
           ans.add(sb);  
        }
        support(root.left, ans, sb+Integer.toString(root.val));
        support(root.right, ans, sb+Integer.toString(root.val));
        
    }
    public int sumNumbers(TreeNode root) {
        List<String> ans = new ArrayList<>();
        support(root, ans, "");
        int sum = 0;
        for(String s : ans) sum+=(Integer.parseInt(s));
        return sum;
    }
}