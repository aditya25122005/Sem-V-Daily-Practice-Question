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
    public void reorderList(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second= slow.next;
        slow.next=null;

        // Reverse second half;
        ListNode prev=null;
        while(second!=null){
            ListNode temp=second.next;
            second.next=prev;
            prev=second;
            second=temp;
        }

        ListNode h1=head;
        ListNode h2=prev;
        while(h2!=null && h1!=null){
            ListNode a=h1.next;
            ListNode b=h2.next;

            h1.next=h2;
            h2.next=a;

            h1=a;
            h2=b;
        }
   
        
    }
}