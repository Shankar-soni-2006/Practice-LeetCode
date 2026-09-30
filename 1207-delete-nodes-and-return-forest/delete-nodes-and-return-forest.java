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
    public TreeNode helper(TreeNode root, List<TreeNode> ans, int[] arr){
        if(root == null) return root;
        root.left = helper(root.left, ans, arr);
        root.right = helper(root.right, ans, arr);
        if(arr[root.val]>0){
            if(root.left!= null) ans.add(root.left);
            if(root.right!= null) ans.add(root.right);
            arr[root.val]--;
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        if(root == null) return ans;
        int[] arr = new int[1001];
        for(int i : to_delete) arr[i]++;
        if(helper(root, ans, arr)!= null) ans.add(root);
        return ans;
    }
}