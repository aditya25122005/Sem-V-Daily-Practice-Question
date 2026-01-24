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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ll= new ArrayList<>();
        Solve(root,ll,k);
        return ll.get(k-1);
    }
    public static void Solve(TreeNode root, List<Integer> ll,int k){
        if(root==null) return;
        Solve(root.left,ll,k);
        if(ll.size()==k) return;
        ll.add(root.val);
        Solve(root.right,ll,k);
    }
}