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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = l1;
        ListNode prev= null;
        

        while(curr!=null ){
            ListNode after= curr.next;
            curr.next = prev;
            prev=curr;
            curr=after;
        }
        ListNode L1=prev;


        ListNode curr2=l2;
        ListNode prev2=null;
        while(curr2!=null){
            ListNode after2=curr2.next;
            curr2.next=prev2;
            prev2=curr2;
            curr2=after2;
        }
        ListNode L2=prev2;

        ListNode ans = new ListNode();
        ListNode dummy=ans;

        ListNode h1=L1;
        ListNode h2=L2;
        int carry=0;

        while(h1!=null && h2!=null){
            int value = h1.val+h2.val+carry;
            int unit= value%10;
            carry=value/10;
            dummy.next= new ListNode(unit);
            dummy=dummy.next;
            h1= h1.next;
            h2=h2.next;
        }
        while(h1!=null){
            int v= h1.val+carry;
            int unit= v%10;
            carry = v/10;
            dummy.next= new ListNode(unit);
            dummy=dummy.next;
            h1=h1.next;
        }
        while(h2!=null){
            int v= h2.val+carry;
            int unit= v%10;
            carry = v/10;
            dummy.next= new ListNode(unit);
            dummy=dummy.next;
            h2=h2.next;
        }
        if(carry!=0){
            dummy.next= new ListNode(carry);
            dummy=dummy.next;
        }
        ListNode res= ans.next;
        // return res;
        ListNode cur= res;
        ListNode pre= null;
        while(cur!=null){
            ListNode ahead= cur.next;
            cur.next=pre;
            pre=cur;
            cur=ahead;
        }
        return pre;
    }
}