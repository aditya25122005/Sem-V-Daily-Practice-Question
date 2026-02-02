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
        
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(size==1) return null;

        int i=0;
        temp=head;
        while(temp.next!=null){
            if(i==(size/2)-1){
                temp.next=temp.next.next;
                break;
            }
            else{
                i++;
                temp=temp.next;
            }
        }
        return head;
    }
}