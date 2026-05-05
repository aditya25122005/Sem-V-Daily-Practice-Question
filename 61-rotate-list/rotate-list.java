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
    public ListNode rotateRight(ListNode head, int k) {

        int size=0;
        ListNode last = null;
        ListNode temp = head;
        while(temp!=null){
            if(temp.next==null){
                last= temp;
            }
            size++;
            temp = temp.next;
        }
        if(size==0) return head;
        k = k%size;
        if(k==0){
            return head;
        }
        // System.out.println(size);
        int curr = 1;
        ListNode temp2 = head;
        while(curr<size-k){
            temp2=temp2.next;
            curr++;
        }
        ListNode newHead = temp2.next;
        temp2.next= null;
        last.next=head;
        return newHead;
        

    }
}