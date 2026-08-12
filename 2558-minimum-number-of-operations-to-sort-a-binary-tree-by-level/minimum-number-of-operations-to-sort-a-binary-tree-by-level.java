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
    public int checker(List<Integer> x){
        int c = 0;
        int n = x.size();
        int[][] arr = new int[n][2];
        for(int i=0; i< n; i++){
            arr[i][0] = x.get(i);
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        boolean[] flag = new boolean[n];
        for(int i =0;i < n; i++){
            if(flag[i] || arr[i][1] == i) continue;
            int cyc = 0;
            int j = i;
            while(!flag[j]){
                flag[j] = true;
                j = arr[j][1];
                cyc++;
            }
            c+=(cyc-1);
        }
        return c;
    }
    public int minimumOperations(TreeNode root) {
        int op = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> x = new ArrayList<>();
            while (s-- > 0) {
                root = q.poll();
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
                x.add(root.val);
            }
            op+=checker(x);
        }
        return op;
    }
}