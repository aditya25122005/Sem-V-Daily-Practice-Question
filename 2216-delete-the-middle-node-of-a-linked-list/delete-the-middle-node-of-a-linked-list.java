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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        int size=1;
        ListNode temp = head;
        while(temp.next!=null){
            temp= temp.next;
            size++;
        }
        int i=1;
        ListNode curr = head;
        while(i<((size)/2)){
            curr=curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;

    }
}