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
        List<Integer> ll= new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            ll.add(temp.val);
            temp= temp.next;
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<ll.size()/2;i++){
            int A= ll.get(i);
            int B= ll.get(ll.size()-i-1);
            ans= Math.max(ans, A+B);
        }
        return ans;
    }
}