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
        int size=1;
        ListNode temp1=head;
        ListNode temp2=head;
        while(temp1!=null){
            temp1=temp1.next;
            size++;
        }
        int i=1;
        while(i<size/2){
            temp2=temp2.next;
            i++;
        }
        ListNode head2= temp2.next;
        temp2.next=null;

        ListNode curr= head2;
        ListNode prev=null;
        while(curr!=null){
            ListNode next= curr.next;
            curr.next=prev;
            prev=curr;
            curr= next;
        }
        ListNode rev= prev;
 

        int ans=Integer.MIN_VALUE;
        while(rev!=null && head!=null){
            int a= rev.val;
            int b= head.val;
            ans=Math.max(ans, a+b);
            rev=rev.next;
            head=head.next;
        }
        return ans;

    }
}