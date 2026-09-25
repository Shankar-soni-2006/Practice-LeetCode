/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Deque<Node> dq = new ArrayDeque<>();
        Node ans = root;
        dq.add(root);
        while(dq.size() > 0){
            int s = dq.size();
            while(s-- > 0){
                root = dq.poll();
                if(s > 0) root.next = dq.peek();
                if(root.left != null) dq.add(root.left);
                if(root.right != null) dq.add(root.right);
            }
        }
        return ans;
    }
}