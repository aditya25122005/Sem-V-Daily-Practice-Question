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
        Solve(root,k,ll);
        return ll.get(k-1);
    }
    public static void Solve(TreeNode root, int k, List<Integer> ll){
        if(ll.size()==k){
            return;
        }
        if(root==null){
            return;
        }
        Solve(root.left,k,ll);
        ll.add(root.val);
        Solve(root.right,k,ll);
    }
}