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
        List<Integer> ll= new ArrayList<>();
        int l=0;
        int ans=0;
        while(head!=null){
            ll.add(head.val);
            head=head.next;
        }
        int n=ll.size();
        for(int i=n-1;i>=0;i--){
            ans+= ll.get(i)* Math.pow(2,l);
            l++;
        }
        return ans;
    }
}