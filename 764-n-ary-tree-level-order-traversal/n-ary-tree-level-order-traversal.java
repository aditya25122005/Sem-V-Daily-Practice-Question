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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ll= new ArrayList<>();
        if(root==null) return ll;
        Queue<Node>q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0;i<size;i++){
                inner.add(q.peek().val);
                for(Node ch:q.peek().children){
                    q.add(ch);
                }
                q.remove();
            }
            ll.add(new ArrayList<>(inner));
        }
        return ll;

    }
}