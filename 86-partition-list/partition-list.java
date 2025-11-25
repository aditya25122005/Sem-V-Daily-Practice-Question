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
    public ListNode partition(ListNode head, int x) {
        ListNode temp=head;
        ListNode ans= new ListNode(0);
        ListNode dummy= ans;
        ListNode t1=head;

        while(temp!=null){
            if(temp.val<x){
                ans.next=new ListNode(temp.val);
                ans=ans.next;
            }
            temp=temp.next;
        }
        while(t1!=null){
            if(t1.val>=x){
                ans.next=new ListNode(t1.val);
                ans= ans.next;
            }
            t1=t1.next;
        }
        return dummy.next;
    }
}