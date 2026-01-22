/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ll;
    public List<Integer> preorder(Node root) {
        ll= new ArrayList<>();
        Solve(root);
        return ll;
    }
    public void Solve(Node root){
        if(root==null){
            return;
        }
        ll.add(root.val);
        for(Node child: root.children){
            Solve(child);
        }
    }
}