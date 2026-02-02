/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp= head;
        int size=0;
        while(temp!=null){
            size++;
            temp= temp.next;
        }

        // Reverse
        ListNode prev=null;
        ListNode curr= head;
        while(curr!=null){
            ListNode next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        int [] ans= new int[size];
        int idx=size-1;

        ListNode nn= prev;
        temp=nn;
        Stack<Integer> st= new Stack<>();
        while(temp!=null){
            int val= temp.val;

            while(!st.isEmpty() && st.peek()<=val){
                st.pop();
            }
            if(st.isEmpty()){
                ans[idx--] = 0;
            }
            else{
                ans[idx--]= st.peek();
            }

            st.push(val);
            temp=temp.next;
        }

        return ans;
        

    }
}