/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr= head;
        Stack<Node> st= new Stack<>();
        while(curr!=null){
            if(curr.child!=null){
                if(curr.next!=null){
                    st.push(curr.next);
                }
                curr.next=curr.child;
                curr.child.prev=curr;
                curr.child=null;
                curr=curr.next;
                if(curr.next==null && !st.isEmpty()){
                    Node rm= st.pop();
                    curr.next=rm;
                    rm.prev=curr;
                }

            }
            else if(curr.next==null && !st.isEmpty()){
                Node rm= st.pop();
                curr.next=rm;
                rm.prev=curr;
                curr=curr.next;
            }
            else{
                curr=curr.next;
            }
        }
        return head;
    }
}