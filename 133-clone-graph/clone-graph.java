/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> mp = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(mp.containsKey(node)) return mp.get(node);
        Node temp = new Node(node.val, new ArrayList<>());
        mp.put(node, temp);
        for(Node i : node.neighbors){
            temp.neighbors.add(cloneGraph(i));
        }
        return temp;
    }
}