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
    public int pairSum(ListNode head) {
        if(head.next==null){
            return head.val;
        }
        ListNode temp = head;
        int size = 1;
        while(temp.next!=null){
            temp= temp.next;
            size++;
        }
        System.out.println(size);
        int i=1;
        temp = head;
        while(i<size/2){
            i++;
            temp=temp.next;
        }
        ListNode curr = temp.next;
        temp.next = null;
        ListNode prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next= prev;
            prev=curr;
            curr=next;
        }
        int ans = 0;
        ListNode demo = head;
        while(prev!=null && demo!=null){
            ans = Math.max(ans,prev.val+ demo.val);
            prev=prev.next;
            demo = demo.next;
        }
        return ans;
    }
}