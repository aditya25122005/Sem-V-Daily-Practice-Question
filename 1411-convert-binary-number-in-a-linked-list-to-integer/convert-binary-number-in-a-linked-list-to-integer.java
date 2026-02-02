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
    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int p=size-1;
        int ans=0;
        temp=head;
        while(temp!=null){
            ans+= (temp.val* (int)Math.pow(2,p--));
            temp=temp.next;
        }
        return ans;
    }
}