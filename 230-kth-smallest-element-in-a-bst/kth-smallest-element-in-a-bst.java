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
    List<Integer> ll;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        ll= new ArrayList<>();
        solve(root,k);
        return ll.get(k-1);
    }
    public void solve(TreeNode root, int k){
        if(root==null) return;
        solve(root.left,k);
        ll.add(root.val);  
        solve(root.right,k);
        
    }
}