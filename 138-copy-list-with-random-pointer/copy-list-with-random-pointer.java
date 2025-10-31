/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map= new HashMap<>();
        Node temp= head;
        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        Node temp2=head;
        while(temp2!=null){
            Node copy=map.get(temp2);
            copy.next=map.get(temp2.next);
            copy.random=map.get(temp2.random);
            temp2=temp2.next;
        }
        return map.get(head);
    }
}