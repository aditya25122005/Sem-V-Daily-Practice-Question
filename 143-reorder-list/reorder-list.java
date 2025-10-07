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
        ListNode second=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(second!=null){
            ListNode temp=second.next;
            second.next=prev;
            prev=second;
            second=temp;
        }

        ListNode a=head;
        ListNode b=prev;
        while(b!=null){
        ListNode temp1=a.next;
        ListNode temp2=b.next;
        a.next=b;
        b.next=temp1;

        a=temp1;
        b=temp2;
        }


      
    }
}