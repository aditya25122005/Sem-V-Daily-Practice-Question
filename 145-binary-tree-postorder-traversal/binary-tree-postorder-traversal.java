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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ll= new ArrayList<>();
        Solve(ll,root);
        return ll;
    }
    public static void Solve(List<Integer> ll, TreeNode root){
        if(root==null){
            return;
        }
        Solve(ll,root.left);
        Solve(ll,root.right);
        ll.add(root.val);
    }
}