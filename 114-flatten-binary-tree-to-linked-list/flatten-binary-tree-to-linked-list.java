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
    public void flatten(TreeNode root) {
        curr= new TreeNode();
        Solve(root);
        root=curr.right;
    }
    TreeNode curr;
    public void Solve(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode left= root.left;
        TreeNode right= root.right;

        curr.right=root;
        curr.left=null;
        curr=curr.right;

        Solve(left);
        Solve(right);



    }
}