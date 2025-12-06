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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Solve(root);

    }
    static int maxD=0;
    public static int Solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int left= 1+ Solve(root.left);
        int right= 1+Solve(root.right);
        return Math.max(left,right);
    }
}