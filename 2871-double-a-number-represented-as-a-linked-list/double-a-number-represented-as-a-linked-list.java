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
    public ListNode doubleIt(ListNode head) {
        int num=0;
        ListNode curr= head;
        ListNode prev=null;
        
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode nn= new ListNode(0);
        ListNode demo=nn;
        ListNode temp=prev;
        int carry=0;

        while(temp!=null){
            int val=carry + temp.val*2;
            int last= val%10;
            carry= val/10;
            demo.next=new ListNode(last);
            demo=demo.next;
            temp=temp.next;
        }

        if(carry!=0){
            demo.next=new ListNode(carry);
        }
        return reverse(nn.next);

    }
    public static ListNode reverse(ListNode head){
        ListNode curr= head;
        ListNode prev=null;
        
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
}