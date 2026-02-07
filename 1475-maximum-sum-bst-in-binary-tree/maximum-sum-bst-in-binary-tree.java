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
    public int maxSumBST(TreeNode root) {
        return Solve(root).ans;
    }
        Pair Solve(TreeNode root){
        if(root==null){
            return new Pair();
        }
        Pair left = Solve(root.left);
        Pair right = Solve(root.right);
        Pair nP= new Pair();
        nP.min=Math.min(left.min,Math.min(right.min,root.val));
        nP.max=Math.max(left.max,Math.max(right.max,root.val));
        nP.sum= left.sum+right.sum+root.val;
        nP.isBST = left.isBST && right.isBST && root.val>left.max && root.val<right.min;
        if(nP.isBST){
            nP.ans=Math.max(left.ans,Math.max(right.ans,nP.sum));
        }
        else{
            nP.ans=Math.max(left.ans,right.ans);
        }
        return nP;

    }
    class Pair{
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        boolean isBST=true;
        int sum=0;
        int ans=0;
    }
}