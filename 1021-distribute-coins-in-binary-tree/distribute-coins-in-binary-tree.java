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
    public int distributeCoins(TreeNode root) {
        steps=0;
        Solve(root);
        return steps;
    }
    static int steps;
    public static int Solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int left= Solve(root.left);
        int right= Solve(root.right);
        steps+= Math.abs(left)+ Math.abs(right);
        return left+right+ root.val-1;
    }
}