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
    public boolean isValidBST(TreeNode root) {
        return Solve(root).isBST;
    }
    public Pair Solve(TreeNode root){
        if(root==null){
            return new Pair();
        }
        Pair left = Solve(root.left);
        Pair right = Solve(root.right);
        Pair nP = new Pair();
        nP.min=Math.min(root.val, Math.min(left.min,right.min));
        nP.max=Math.max(root.val, Math.max(left.max,right.max));
        nP.isBST = left.isBST && right.isBST && left.max<root.val && root.val<right.min;
        return nP;
    }
    class Pair{
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        boolean isBST=true;
    }
}