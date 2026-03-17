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
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer,Node> map= new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(node);
        while(!q.isEmpty()){
            Node rm= q.poll();
            if(visited.contains(rm.val)){
                continue;
            }
            visited.add(rm.val);

            if(!map.containsKey(rm.val)){
                map.put(rm.val, new Node(rm.val));
            }

            for(Node oldNbr : rm.neighbors){
                if(!map.containsKey(oldNbr.val)){
                    map.put(oldNbr.val,new Node(oldNbr.val));
                }

                map.get(rm.val).neighbors.add(map.get(oldNbr.val));
                q.add(oldNbr);
              
            }
        }
        return map.get(node.val);
    }
}