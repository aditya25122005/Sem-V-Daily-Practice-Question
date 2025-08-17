/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1= new ArrayList<>();
        List<Integer> l2= new ArrayList<>();
        solve(root1,l1);
        solve(root2,l2);
        for(int val:l2){
            l1.add(val);
        }
        Collections.sort(l1);
        return l1;


    }
    public void solve(TreeNode root,List<Integer> ll){
        if(root==null) return;
        solve(root.left,ll);
        ll.add(root.val);
        solve(root.right,ll);
    }
}